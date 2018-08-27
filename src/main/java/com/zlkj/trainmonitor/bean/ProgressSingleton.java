package com.zlkj.trainmonitor.bean;

import java.util.Hashtable;

public class ProgressSingleton {
    //为了防止多用户并发，使用线程安全的Hashtable
    private static Hashtable<String, Long> table = new Hashtable<>();

    public static void put(String key, Long value) {
        table.put(key, value);
    }

    public static Long get(String key) {
        return table.get(key);
    }

    public static Long remove(String key) {
        return table.remove(key);
    }
}