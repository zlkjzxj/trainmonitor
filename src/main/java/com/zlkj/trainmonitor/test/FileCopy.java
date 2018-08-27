package com.zlkj.trainmonitor.test;

import com.zlkj.trainmonitor.bean.ProgressSingleton;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;

public class FileCopy {
    //复制方法
    public static long copy(String src, String des,String filePathProgress) {
//        String filePathProgress=0;
//        String[] filePPs = filePathProgress.split("#");
//        String filePP = filePPs[0];
//        long fileRestSize = Long.parseLong(filePPs[1]);
        long fileRestSize = 0;

//        String[] fPS = filePSize.split("#");, String filePSize
//        String fileP = fPS[0];
//        long fSize = Long.parseLong(fPS[1]);
        //初始化文件复制
        File file1=new File(src);
        //把文件里面内容放进数组
        File[] fs=file1.listFiles();
        //初始化文件粘贴
        File file2=new File(des);
        //判断是否有这个文件有不管没有创建
        if(!file2.exists()){
            file2.mkdirs();
        }
        try {
            //遍历文件及文件夹
            for (File f : fs) {
                if(f.isFile() && !f.isHidden()){
                    //文件

                    // 1.提供读入、写出的流
                    File file3 = new File(f.getPath());
                    File file4 = new File(des+"\\"+f.getName());
                    if(!file4.exists()){
                        file4.createNewFile();
                    }
                    //io流固定格式
                    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file3));
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file4));
                    int i = -1;//记录获取长度

                    byte[] bt = new byte[10*1024];//缓冲区
                    while ((i = bis.read(bt))!=-1) {
                        fileRestSize = fileRestSize + i;
                        //向单例哈希表写入进度
                        ProgressSingleton.put(filePathProgress, fileRestSize);
                        bos.write(bt, 0, i);
                    }
                    bis.close();
                    bos.close();
                }else if(f.isDirectory()){
                    //文件夹
                    //String fpp = filePP.concat("#").concat(Long.toString(fileRestSize));
                  return fileRestSize+copy(f.getPath(),des+"\\"+f.getName(),filePathProgress);//继续调用复制方法      递归的地方,自己调用自己的方法,就可以复制文件夹的文件夹了
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileRestSize;
    }

    /**
     * 复制文件传已经上传byte[]的大小给HashTable
     * @param sourcePath 源文件/文件夹
     * @param targetPath 目标文件/文件夹
     * @param filePathProgress 源文件进度
     */
    public static void copy1 (String sourcePath,String targetPath,String filePathProgress){
        long fileRestSize = 0;
        try {
            Path startingDir = Paths.get(sourcePath);
            List<Path> result = new LinkedList<Path>();
            //读取文件列表
            Files.walkFileTree(startingDir, new FindJavaVisitor(result));
            for (Path p :result){
                //读取需要复制的文件
                File sourceFile= new File(p.toString());
                //替换源文件路径到目标文件夹
                String tarPath = p.getParent().toString().replace(sourcePath,targetPath);
                //创建目标文件文件夹
                File fileTarPath = new File(tarPath);
                if(!fileTarPath.exists()){
                    fileTarPath.mkdirs();
                }
                //源文件文件名
                String fName = p.getFileName().toString();
                //拼接目标文件路径和文件名
                tarPath = tarPath.concat("\\").concat(fName);
                //创建目标文件
                File targetFile = new File(tarPath);
                if(!targetFile.exists()){
                    targetFile.createNewFile();
                }
                //io流固定格式
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(targetFile));
                int i = -1;//记录获取长度

                byte[] bt = new byte[10*1024];//缓冲区
                while ((i = bis.read(bt))!=-1) {
                    fileRestSize = fileRestSize + i;
                    //向单例哈希表写入进度
                    ProgressSingleton.put(filePathProgress, fileRestSize);
                    bos.write(bt, 0, i);
                }
                bis.close();
                bos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取文件列表的方法
     */
    private static class FindJavaVisitor extends SimpleFileVisitor<Path> {
        private List<Path> result;
        private String fileSuffix = null;
        public FindJavaVisitor(List<Path> result){
            this.result = result;
        }
        public FindJavaVisitor(List<Path> result,String fileSuffix){
            this.result = result;
            this.fileSuffix = fileSuffix;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs){
            //是否判断后缀名
            if(fileSuffix!=null && !"".equals(fileSuffix)){
                if(file.toString().endsWith(fileSuffix)){
                    result.add(file);
                }
            }else {
                //result.add(file.getFileName());
                result.add(file);
            }
            //System.out.println(file.toUri());
            return FileVisitResult.CONTINUE;
        }
    }


    /**
     * 文件复制的具体方法
     */
//    public static long fileCopy(String begin, String end, String filePathProgress, long fileRestSize) throws Exception {
//        // 1.提供读入、写出的流
//        File file1 = new File(begin);
//        File file2 = new File(end);
//        if(!file2.exists()){
//            file2.createNewFile();
//        }
//        //io流固定格式
//        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file1));
//        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file2));
//        int i = -1;//记录获取长度
//
//        byte[] bt = new byte[10*1024];//缓冲区
//        while ((i = bis.read(bt))!=-1) {
//            fileRestSize = fileRestSize + i;
//            //向单例哈希表写入进度
//            ProgressSingleton.put(filePathProgress, fileRestSize);
//            bos.write(bt, 0, i);
//        }
//        bis.close();
//        bos.close();
//        //关闭流
//        return fileRestSize;
//    }

    public static long getTotalSize(String sourcePath) {
        long total = 0;

        try {
            Path startingDir = Paths.get(sourcePath);
            List<Path> result = new LinkedList<Path>();
            //读取文件列表
            Files.walkFileTree(startingDir, new FindJavaVisitor(result));
            for (Path p :result){
                //读取需要复制的文件
                File sourceFile= new File(p.toString());
                total+=sourceFile.length();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return total;
    }

    public static void main(String[] args) {

    }
}
