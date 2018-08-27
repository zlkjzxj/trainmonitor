package com.zlkj.trainmonitor.services;

import com.zlkj.trainmonitor.threads.OutPutThread;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class OutData {
    public void outData(String disk_str) {
        String[] disks = disk_str.split(",");
        long ks = new Date().getTime();
        //生成对应数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(disks.length);
        //循环得到每个线程
        for (int i = 0; i < disks.length; i++) {
            executorService.execute(new OutPutThread(disks[i]));//i是线程名，xh是定时任务序号
        }
        long js = new Date().getTime();
        long ys = (js-ks);
        System.out.println(ys+"用时");
        executorService.shutdown();//执行完毕关闭线程池

    }

    public static void main(String[] args) {
        new OutData().outData("a,b,c");
    }
}
