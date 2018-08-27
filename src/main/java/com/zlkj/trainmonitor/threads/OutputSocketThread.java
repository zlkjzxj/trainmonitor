package com.zlkj.trainmonitor.threads;

import com.google.gson.Gson;
import com.zlkj.trainmonitor.bean.DiskInfo;
import com.zlkj.trainmonitor.commons.Constant;
import com.zlkj.trainmonitor.test.CheckEquType;
import com.zlkj.trainmonitor.test.ReadWriteProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class OutputSocketThread implements Runnable {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    private WebSocketSession session;
    private boolean flag;
    private static OutputSocketThread outputDataThread;

    private OutputSocketThread() {
        this.session = session;
        this.flag = flag;
    }

    public static synchronized OutputSocketThread getInstance() {
        if (outputDataThread == null) {
            outputDataThread = new OutputSocketThread();
        }
        return outputDataThread;
    }

    public void setFlag(WebSocketSession session, boolean flag) {
        this.session = session;
        this.flag = flag;
    }

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            i++;
            try {
                String s = CheckEquType.checkEquTypeString();

                if (s.length() > 0 && session != null) {
                    List<DiskInfo> list = getTrainInfo(s);
                    session.sendMessage(new TextMessage(new Gson().toJson(list)));
                    logger.info(s + i + "数据导出线程列车信息");
                } else {
                    session.sendMessage(new TextMessage("0"));
                }
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static List<DiskInfo> getTrainInfo(String diskStr) {
        List<DiskInfo> trainInfoList = new ArrayList<>();
        String[] disks = diskStr.split("#");
        String str = "";
        if(disks.length>0) {
            for (String disk : disks) {
                String[] dinfo = disk.split(",");
                String trainInfo = new ReadWriteProperties().getProperty(Constant.TRAININFO, dinfo[0].concat(Constant.WRITEINITNAME));
                try {
                    str=new String(trainInfo.getBytes("ISO-8859-1"),"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                DiskInfo train = new DiskInfo();
                train.setDiskid(dinfo[0]);
                train.setTotalSize(dinfo[1]);
                train.setFreeSize(dinfo[2]);
                train.setTrainInfo(str);
                if( trainInfo!=null && !"".equals(trainInfo)){
                    train.setHasini(true);
                }
                trainInfoList.add(train);
            }
        }
        return trainInfoList;
    }

    public static void main(String[] args) {
//        Thread thread = new Thread(new OutputSocketThread());
//        thread.start();

        String str = "G:,6.90G,1.13G#I:,7.48G,5.15G112";
        List<DiskInfo> ss= getTrainInfo(str);
        System.out.println(ss.iterator());
    }
}
