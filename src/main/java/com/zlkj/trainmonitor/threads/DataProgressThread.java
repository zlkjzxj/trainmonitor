package com.zlkj.trainmonitor.threads;

import com.google.gson.Gson;
import com.zlkj.trainmonitor.bean.DiskInfo;
import com.zlkj.trainmonitor.bean.ProgressSingleton;
import com.zlkj.trainmonitor.commons.Constant;
import com.zlkj.trainmonitor.test.CheckEquType;
import com.zlkj.trainmonitor.test.ReadWriteProperties;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class DataProgressThread implements Runnable {
    private static List<String> disksList;
    private WebSocketSession session;
    private boolean flag;

    //    public TestThread(WebSocketSession session, boolean flag) {
//        this.session = session;
//        this.flag = flag;
//    }
    private static DataProgressThread initThread;

    private DataProgressThread() {
        this.session = session;
        this.flag = flag;
    }


    public static synchronized DataProgressThread getInstance() {
        if (initThread == null) {
            initThread = new DataProgressThread();
        }
        return initThread;
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
                //各个盘符分隔
                List<DiskInfo> dlist = new ArrayList<DiskInfo>();
                ReadWriteProperties rif = new ReadWriteProperties();
                String disksstr = CheckEquType.checkEquTypeString();
                List<String> newdlist = new ArrayList<>();
                if(disksstr!=null && !"".equals(disksstr)){
                    String[] disks=disksstr.split("#");
                    for (int j = 0; j < disks.length; j++) {
                        String[] dinfo = disks[j].split(",");
                        if(disksList != null && disksList.size()!=0){
                            for (int k = 0; k < disksList.size(); k++) {
                                if(disksList.get(k).equals(dinfo[0])){
                                    disksList.remove(k);
                                }
                            }
                        }
                        newdlist.add(dinfo[0]);
                        String str = "";
                        Long s = ProgressSingleton.get(dinfo[0]+"Progress");
                        Long all = ProgressSingleton.get(dinfo[0]+"Size");
                        System.out.println(s+"-------------------------------------------------///已经传输"+dinfo[0]);
                        System.out.println(all+"/********************************总传输"+dinfo[0]);
                        //列车信息
                        String filePath = dinfo[0].concat("\\"+Constant.WRITEINITNAME);
                        //根据列车信息键和列车信息ini文件位置 取列车信息
                        String traininfo = rif.getProperty(Constant.TRAININFO,filePath);
                        try {
                            str=new String(traininfo.getBytes("ISO-8859-1"),"UTF-8");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        DiskInfo diskinfo = new DiskInfo();
                        diskinfo.setDiskid(dinfo[0]);
                        diskinfo.setTrainInfo(str);
                        if (s != null && all != null && s > 0 && all>=s && session != null) {
                            Float cc = (float) s / all * 100;
                            diskinfo.setProgress(String.valueOf(cc));
                            //                        System.out.println(s + i);
                        } else {
                            diskinfo.setProgress("0");
                        }
                        dlist.add(diskinfo);
                    }
                    if(disksList != null && disksList.size()!=0){
                        for (int m = 0; m < disksList.size(); m++) {
                            String filePathSize = disksList.get(m).concat("Size");
                            String filePathProgress = disksList.get(m).concat("Progress");
                            ProgressSingleton.put(filePathProgress, 0L);
                            ProgressSingleton.put(filePathSize, 0L);//当前文件的总大小, filePSize
                        }
                    }
                    disksList=newdlist;
                }
                String djson = new Gson().toJson(dlist);
                session.sendMessage(new TextMessage(djson));
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Thread thread = new Thread(new DataProgressThread());
        thread.start();
    }
}
