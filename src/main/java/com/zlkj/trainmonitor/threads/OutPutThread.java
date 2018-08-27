package com.zlkj.trainmonitor.threads;

import com.zlkj.trainmonitor.bean.ProgressSingleton;
import com.zlkj.trainmonitor.commons.Constant;
import com.zlkj.trainmonitor.test.FileCopy;

import java.io.File;

public class OutPutThread implements Runnable {
    private String disk;

    public OutPutThread() {
    }

    public OutPutThread(String disk) {
        this.disk = disk;
    }

    @Override
    public void run() {
        boolean flag = true;
        while (flag) {
            System.out.println("数据开始导出！！！");
            System.out.println(Math.random());
            try {
                Thread.sleep(Math.round(Math.random() * 3000));
                //执行数据导出功能
                /**
                 * 指定导出文件夹，
                 * 1.时间
                 *  a.时间可以根据文件时间，但是设备时间可能有问题
                 *  b.时间根据服务器时间，但是如果是昨天录的视频，时间就有问题
                 *  c.用户手动选择时间
                 *  d.组合时间，假如用户不选，就用文件时间，选了就用用户选择时间
                 * 2.车队
                 * 3.车组
                 * 4.车次
                 * 5.车厢号
                 *
                 */
                File dir = new File(Constant.WRITEFILETO);
                if (!dir.exists()) {
                    dir.mkdir();
                }
                long dSize = FileCopy.getTotalSize(disk);
                String filePathSize = disk.concat("Size");
                ProgressSingleton.put(filePathSize, dSize);//当前文件的总大小, filePSize
                String filePathProgress = disk.concat("Progress");

                FileCopy.copy1(disk, Constant.WRITEFILETO ,filePathProgress);
                System.out.println("数据导出结束！！！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                flag = false;
            }
        }
    }
}



