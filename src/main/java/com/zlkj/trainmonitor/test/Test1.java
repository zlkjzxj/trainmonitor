package com.zlkj.trainmonitor.test;

import com.zlkj.trainmonitor.bean.ProgressSingleton;

import java.io.*;

public class Test1 {

    public static void writeFile(String begin, String end) {
        {
            // 3.将创建的节点流的对象作为形参传递给缓冲流的构造器中
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;
            try {
                // 1.提供读入、写出的流
                File file1 = new File(begin);
                File file2 = new File(end);
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                // 2.创建相应的节点流
                FileInputStream fis = new FileInputStream(file1);
                FileOutputStream fos = new FileOutputStream(file2);
                //使用sessionid + 文件名生成文件号
//                String id = file1.getName();
                String id = "aaa";
                //向单例哈希表写入文件长度和初始进度
                ProgressSingleton.put(id + "Size", file1.length());
                //文件进度长度
                long progress = 0;
                bis = new BufferedInputStream(fis);
                bos = new BufferedOutputStream(fos);
                // 4.实现文件的复制
                byte[] b = new byte[10*1024];// 每次运20个，可按照实际文件大小调整
                int len;
                while ((len = bis.read(b)) != -1) {
                    progress = progress + len;
                    //向单例哈希表写入进度
                    ProgressSingleton.put(id + "Progress", progress);
                    bos.write(b, 0, len);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {// 关闭相应的流
                if (bos != null) {
                    try {
                        bos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (bis != null)
                            try {
                                bis.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                    }
                }

            }

        }
    }

    public static void main(String[] args) {

        int x=1;
        switch (x){
            case 1:
                System.out.println(1);
                break;
            case 0:
                System.out.println(0);
                break;
                default:
                    System.out.println("default");
        }

//        long time1 = System.currentTimeMillis();
//        writeFile("D:\\devloptools\\websphere.rar", "F:\\websphere.rar");
//        long time2 = System.currentTimeMillis();
//        System.out.println("消耗时间：" + (time2 - time1));
    }
}
