package com.zlkj.trainmonitor.test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    //首先检测插入几个设备
    public static void main(String[] args) {
        Map<String,Integer> resultMap = new HashMap();
        List<String> no_init = new ArrayList<>();
        long time1 = System.currentTimeMillis();
        //1.启动测试U盘插入程序 相当于用户插入所有设备之后登陆系统
//        Map<String, Boolean>  map = CheckInputEq.getEq();
        //2.筛选出不是系统盘的磁盘
        List<String> disks = CheckEquType.checkEquType();
        System.out.println(disks.size());
        //3.判断磁盘有没有配置文件
        for (String disk: disks) {
            System.out.println(disk);
            boolean b = ReadInitFile.getInitFile(disk);
            if(!b){
                no_init.add(disk);
            }else{//启动线程读文件到指定目录下
                File dir = new File("F:\\test\\");
                if(!dir.exists()){
                    dir.mkdir();
                }
                ReadInitFile.getDirs(disk,"F:\\test\\");
            }
        }
        System.out.println("程序结束");
        long time2 = System.currentTimeMillis();
        System.out.println("消耗时间："+(time2-time1));
    }
}
