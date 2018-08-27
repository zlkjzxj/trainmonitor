package com.zlkj.trainmonitor.test;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

public class CheckInputEq {
    // 存放磁盘状态
    private static Map<String, Boolean> map = new LinkedHashMap<String, Boolean>();
    // 定义磁盘
    private static final String[] arr = new String[] {"C", "D", "E", "F", "G", "H", "I", "J"};
    public static void main(String[] args){
        init();
        check();
        System.out.println("检测到U盘");
        System.out.println(map);
    }
    public static Map<String, Boolean> getEq(){
        init();
        check();
        System.out.println("检测到U盘");
        System.out.println(map);
        return map;
    }
    // 死循环检测每个磁盘状态
    public static void check() {
        File file ;
        for(;;) {
            for(String str : arr) {
                file = new File(str + ":\\");
                // 如果磁盘现在存在，并且以前不存在
                // 则表示刚插上U盘，返回
                if(file.exists() && !map.get(str)) {
                    return;
                }
                // 需要每次状态改变时，更新保存的状态
                // 如果刚检测的状态和原来的状态不一样，则重新更新状态
                // 必须放上面的if语句下面
                if(file.exists() != map.get(str)) {
                    map.put(str, file.exists());
                }
            }
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    // 初始化磁盘状态，存在true， 否则false
    public static void init() {
        File file ;
        for(String str : arr) {
            file = new File(str + ":\\");
            map.put(str, file.exists());
        }
    }
}
