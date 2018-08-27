package com.zlkj.trainmonitor.test;

import com.zlkj.trainmonitor.bean.ResultBean;
import com.zlkj.trainmonitor.commons.Constant;

import java.io.*;
import java.util.List;

public class ReadInitFile {

    public ReadInitFile() {
    }

    public static boolean getInitFile(String filePath) {
        filePath = filePath.concat(Constant.WRITEINITNAME);
        File file = new File(filePath);
        if (file.exists()) {
            return true;
        }
        return false;
    }

    /**
     * 初始ini化文件，不存在创建ini文件，存在返回已经存在的信息
     * @param filePath
     * @param trainInfo
     * @return
     * @throws IOException
     */
    public static ResultBean InitFile(String filePath, String trainInfo, String flag) throws IOException {
        ResultBean resultBean = null;
        ReadWriteProperties rif = new ReadWriteProperties();
        filePath = filePath.concat(Constant.WRITEINITNAME);
        String str = "";
        File file = new File(filePath);
        if(Integer.parseInt(flag)==0){
            if(!file.exists()){
                file.createNewFile();
                rif.setProperty(Constant.TRAININFO,trainInfo,filePath);
                resultBean = new ResultBean("1", "设初始化成功", null);
            }else{
                String traininfo = rif.getProperty(Constant.TRAININFO,filePath);
                try {
                    str=new String(traininfo.getBytes("ISO-8859-1"),"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                resultBean = new ResultBean("0", "设备已初始化", str);
            }
        }else if(Integer.parseInt(flag)==1){
            rif.setProperty(Constant.TRAININFO,trainInfo,filePath);
            resultBean = new ResultBean("1", "设初始化成功", null);
        }
        return resultBean;
    }

    public static void ee() {
        List<String> disks = CheckEquType.checkEquType();
        //3.判断磁盘有没有配置文件
        String path = "";
        String trainInfo = "";
        for (String disk : disks) {
            System.out.println(disk);
            path = disk + "\\init.ini";
            boolean b = ReadInitFile.getInitFile(path);
//            System.out.println(b);
            //若果不存在则给它写入
            if (!b) {
                try {
                    InitFile(path,trainInfo,"0");
                    ee();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        ee();
    }

    public static void writeFile(String begin, String end) {
        {
            // 3.将创建的节点流的对象作为形参传递给缓冲流的构造器中
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;
            try {
                // 1.提供读入、写出的流
                File file1 = new File(begin);
                File file2 = new File(end);
                // 2.创建相应的节点流
                FileInputStream fis = new FileInputStream(file1);
                FileOutputStream fos = new FileOutputStream(file2);
                bis = new BufferedInputStream(fis);
                bos = new BufferedOutputStream(fos);
                // 4.实现文件的复制
                byte[] b = new byte[1024];// 每次运20个，可按照实际文件大小调整
                int len;
                while ((len = bis.read(b)) != -1) {
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

    public static void getDirs(String dirPath,String path){
        File dir = new File(dirPath);
        if(dir.exists()){
            System.out.println(dir);
            //遍历目录
            if(dir.isDirectory()){//如果是目录，继续遍历
                File[] files = dir.listFiles();
                if(files!=null){//必须判断，有可能是空文件夹
                    for (File file: files) {
                        getDirs(file.getAbsolutePath(),path);
                    }
                }
            }else{
                String name = dir.getName();
                if(!dir.isHidden()&&name.endsWith(".mp4")){//判断如果不是隐藏文件
                    writeFile(dir.getAbsolutePath(),path+name);
                }
            }
        }
    }

}