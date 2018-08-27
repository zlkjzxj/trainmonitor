package com.zlkj.trainmonitor.test;

import com.zlkj.trainmonitor.bean.DiskInfo;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T1 {
    String configpath = "d://conifg.ini";
    private static Properties properties =new Properties();
    FileInputStream fis = null; // 读
    OutputStream fos ;




    public static List<DiskInfo> checkEquType() {
        File[] files = File.listRoots();
        FileSystemView fileSystemView = FileSystemView.getFileSystemView();
        List<DiskInfo> disks = new ArrayList<DiskInfo>();
        for (int i = 0; i < files.length; i++) {
            DiskInfo cinit=new DiskInfo();
            String diskType = fileSystemView.getSystemTypeDescription(files[i]);
            String name = fileSystemView.getSystemDisplayName(files[i]);
//            System.out.println(name);
            String regex = "\\((.*)\\)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(name);//匹配类
            while (matcher.find()) {
                if (!diskType.equals("本地磁盘")) {
                    cinit.setDiskid(matcher.group(1));
                    disks.add(cinit);
                }
            }
        }
        return dlist(disks);

    }

    public static List<DiskInfo> dlist (List<DiskInfo> disks){
        //3.判断磁盘有没有配置文件
        String path = "";
        for (DiskInfo disk : disks) {
            System.out.println(disk);
            path = disk + "\\init.ini";
            boolean b = ReadInitFile.getInitFile(path);
            System.out.println(b);
            //若果不存在则给它写入
//            if (!b) {
//                try {
//                    InitFile(path);
//                    //ee();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        }
        return disks;
    }




        public T1() {
            try {
                fis = new FileInputStream(configpath);
                properties.load(fis);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        public String getProperty(String key){
            Object object = properties.get(key);
            return object.toString();
        }

        public void setProperty(String key, String value){
            try {
                fos = new FileOutputStream(configpath);// 加载读取文件流
                properties.setProperty(key, value);
                properties.store(fos, null);
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        /**
         * @param args
         */
        public static void main(String[] args) {
//            T1 ini = new T1();
//            System.out.println(ini.getProperty("reportFile"));
//            ini.setProperty("reportFile", "D://aa");
//            System.out.println(ini.getProperty("reportFile"));
//            ini.setProperty("keyStoreFile", "C://ee");
//            System.out.println(ini.getProperty("keyStoreFile"));

//            Long f=10L;
//            Long f1 = 30L;
//            Float f2 = (float)f/f1;
//            System.out.println(f2);
//            String filePathProgress = "H:Progress|0";
//            String[] filePPs = filePathProgress.split("");
//            String filePP = filePPs[0];
//            long fileRestSize = Long.parseLong(filePPs[1]);
//            System.out.println(filePP);
//            System.out.println(fileRestSize);


//            String filePath="I:\\01053_PowerDesigner.mp4";

                // Java8用流的方式读文件，更加高效

//                Path path = Paths.get("I:\\01053_PowerDesigner.mp4");

//                boolean pathExists =
//                        Files.exists(path,
//                                new LinkOption[]{ LinkOption.NOFOLLOW_LINKS});
//                System.out.println(pathExists);
//                Path p = Paths.get("F:\\testUSB");
//                Path newDir = Files.createDirectory(p);
//                System.out.println(newDir);

                //Path sourcePath = Paths.get("I:\\");
                //System.out.println(sourcePath.getName(0));
//                Path destinationPath = Paths.get("F:\\testUSB1\\01053_PowerDesigner.mp4");
//                Files.copy(sourcePath, destinationPath);

//                Path pt = Paths.get("I:\\02_《Java8编程入门》");
//                Path pt1 = Paths.get("F:\\testUSB");
//                Object oo = pt.toFile();
//                System.out.println(oo);
//                Path dir = Paths.get("I:\\");
//                try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir)){
//                    for(Path e : stream){
//                        System.out.println(e.getFileName());
//                    }
//                }catch(IOException e){
//
//                }
//                try (Stream<Path> stream = Files.list(Paths.get("I:/"))){
//                    Iterator<Path> ite = stream.iterator();
//                    while(ite.hasNext()){
//                        Path pp = ite.next();
//                        System.out.println(pp.getFileName());
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            for (int i = 0; i < 1000; i++) {
//                int j = Math.random()*1000;
//            }

//driver();
//            List<String> list = new ArrayList<>();
//            list.add("aa");
//            list.add("bb");
//            list.add("cc");
//
//            System.out.println(list);
//
////            System.out.println(str.split("#"));
//            boolean ss = list.remove("aa");
//            System.out.println(list);
//            list.add("dd");
//            System.out.println(list);

            long s = 19222;
            long all = 122222;
            float cc = (float)s/all;
            System.out.println(cc);
        }
    public static String FormetFileSize(long fileS) {
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        if (fileS < 1024) {
            fileSizeString = df.format((double) fileS) + "B";
        } else if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024) + "K";
        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576) + "M";
        } else {
            fileSizeString = df.format((double) fileS / 1073741824) + "G";
        }
        return fileSizeString;
    }

    /**
     * 获取硬盘的每个盘符
     */
    public static void driver(){
        // 当前文件系统类
        FileSystemView fsv = FileSystemView.getFileSystemView();
        // 列出所有windows 磁盘
        File[] fs = File.listRoots();
        // 显示磁盘卷标
        for (int i = 0; i < fs.length; i++) {
            System.out.println(fsv.getSystemDisplayName(fs[i]));
            System.out.print("总大小" + FormetFileSize(fs[i].getTotalSpace()));
            System.out.println("剩余" + FormetFileSize(fs[i].getFreeSpace()));
        }
    }

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

        /**
         *
         * @param file 需要查看的文件或文件夹
         * @param attrs 文件的后缀名
         * @return
         */
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

    public static void fileCopy(String sourceFile,String targetPath,String filePathProgress){
        long fileRestSize = 0;
        try {
            Path startingDir = Paths.get("I:/");
            Path desDir = Paths.get("F:/test/");
            List<Path> result = new LinkedList<Path>();
            Files.walkFileTree(startingDir, new FindJavaVisitor(result,".mp4"));
            for (Path p :result){

                File f= new File(p.toString());//初始化文件粘贴
                String tarPath = p.getParent().toString().replace("I:\\","F:\\test\\");
                String fName = p.getFileName().toString();
                System.out.println(fName);
                File fileTarPath = new File(tarPath);
                if(!fileTarPath.exists()){
                    fileTarPath.mkdirs();
                }
                tarPath = tarPath.concat("\\").concat(fName);
                System.out.println(tarPath);

                File file2=new File(desDir.toUri());
                //判断是否有这个文件有不管没有创建
                if(!file2.exists()){
                    file2.mkdirs();
                }
                //1.提供读入、写出的流
                File file3 = new File(f.getPath());
                File file4 = new File(tarPath);
                if(!file4.exists()){
                    file4.createNewFile();
                }
                //io流固定格式
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file4));
                int i = -1;//记录获取长度

                byte[] bt = new byte[10*1024];//缓冲区
                while ((i = bis.read(bt))!=-1) {
                    fileRestSize = fileRestSize + i;
                    //向单例哈希表写入进度
                    // ProgressSingleton.put(filePathProgress, fileRestSize);
                    bos.write(bt, 0, i);
                }
                bis.close();
                bos.close();


//                    Path ps = Paths.get();
//                    System.out.println(p.getParent());
                //Files.copy(p,ps, StandardCopyOption.REPLACE_EXISTING);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
