package com.zlkj.trainmonitor.test;

import com.zlkj.trainmonitor.bean.DiskInfo;
import com.zlkj.trainmonitor.commons.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckEquType {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public static List<DiskInfo> checkEquTypeDisks() {
        File[] files = File.listRoots();
        FileSystemView fileSystemView = FileSystemView.getFileSystemView();
        List<DiskInfo> disks = new ArrayList<DiskInfo>();
        for (int i = 0; i < files.length; i++) {
            String diskType = fileSystemView.getSystemTypeDescription(files[i]);
            String name = fileSystemView.getSystemDisplayName(files[i]);
//            System.out.println(name);
            String regex = "\\((.*)\\)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(name);//匹配类
//            System.out.println(matcher.find());
            while (matcher.find()) {
                if (!diskType.equals("本地磁盘")) {
                    if(files[i].getTotalSpace()<104857600){
                        continue;
                    }
                    DiskInfo info = new DiskInfo();
                    info.setTotalSize(FormetFileSize(files[i].getTotalSpace()));
                    info.setFreeSize(FormetFileSize(files[i].getFreeSpace()));
                    info.setDiskid(matcher.group(1));
                    disks.add(info);
                }
            }
        }
        return disks;
    }

    public static void main(String[] args) {
//        List<String> disks = checkEquType();
//        for (int i = 0; i < disks.size(); i++) {
//            System.out.println(disks.get(i));
//        }
//        List<DiskInfo> disks = checkEquTypeDisks();
//        for (int i = 0; i < disks.size(); i++) {
//            System.out.println(disks.get(i).getTotalSize()+"////"+disks.get(i).getFreeSize());
//        }

        String s = checkEquTypeString();
        System.out.println(s);
    }

    public static String checkEquTypeString() {
        List<DiskInfo> disks = checkEquTypeDisks();
        StringBuffer buffer = new StringBuffer();
        List<String> dlist = new ArrayList<>();
        String trainInfoStr="";
        if(disks!= null && disks.size()>0) {
            for (DiskInfo dinfo : disks) {
                String trainInfo = new ReadWriteProperties().getProperty(Constant.TRAININFO, dinfo.getDiskid().concat(Constant.WRITEINITNAME));
                try {
                    trainInfoStr = new String(trainInfo.getBytes("ISO-8859-1"), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                buffer.append(dinfo.getDiskid()).append(",");
                buffer.append(dinfo.getTotalSize()).append(",");
                buffer.append(dinfo.getFreeSize()).append(",");
                buffer.append(trainInfoStr).append("#");
            }
            return buffer.substring(0, buffer.length() - 1);
        }
        return "";
    }

    /**
     * 转long为GB
     * @param fileS
     * @return
     */
    public static String FormetFileSize(long fileS) {
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        if (fileS < 1024) {
            fileSizeString = df.format((double) fileS) + "B";
        } else if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024) + "KB";
        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576) + "MB";
        } else {
            fileSizeString = df.format((double) fileS / 1073741824) + "GB";
        }
        return fileSizeString;
    }

    public static List<String> checkEquType() {
        File[] files = File.listRoots();
        FileSystemView fileSystemView = FileSystemView.getFileSystemView();
        List<String> disks = new ArrayList<String>();
        for (int i = 0; i < files.length; i++) {
            String diskType = fileSystemView.getSystemTypeDescription(files[i]);
            String name = fileSystemView.getSystemDisplayName(files[i]);
//            System.out.println(name);
            String regex = "\\((.*)\\)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(name);//匹配类
//            System.out.println(matcher.find());
            while (matcher.find()) {
                if (!diskType.equals("本地磁盘")) {
                    System.out.println(matcher);
                    disks.add(matcher.group(1));
                }
            }
        }
        return disks;
    }

//    public static String checkEquTypeString2() {
//        List<String> disks = checkEquType();
//        StringBuffer buffer = new StringBuffer();
//        for (int i = 0; i < disks.size(); i++) {
//            System.out.println(disks.get(i));
//            buffer.append(disks.get(i));
//            if(i<disks.size()-1){
//                buffer.append(",");
//            }
//        }
//        return buffer.toString();
//    }
}
