package com.zlkj.trainmonitor.bean;

public class DiskInfo {
    private String diskid;//盘符
    private boolean hasini;//是否有初始化文件
    private String trainInfo;//车次信息
    private String totalSize;
    private String freeSize;
    private String progress;

    public DiskInfo() {
    }

    public DiskInfo(String diskid, String trainInfo) {
        this.diskid = diskid;
        this.trainInfo = trainInfo;
    }

    public DiskInfo(String diskid, String trainInfo, String totalSize, String freeSize, String progress) {
        this.diskid = diskid;
        this.trainInfo = trainInfo;
        this.totalSize = totalSize;
        this.freeSize = freeSize;
        this.progress = progress;
    }

    public String getDiskid() {
        return diskid;
    }

    public void setDiskid(String diskid) {
        this.diskid = diskid;
    }

    public boolean isHasini() {
        return hasini;
    }

    public void setHasini(boolean hasini) {
        this.hasini = hasini;
    }

    public String getTrainInfo() {
        return trainInfo;
    }

    public void setTrainInfo(String trainInfo) {
        this.trainInfo = trainInfo;
    }

    public String getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(String totalSize) {
        this.totalSize = totalSize;
    }

    public String getFreeSize() {
        return freeSize;
    }

    public void setFreeSize(String freeSize) {
        this.freeSize = freeSize;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }
}
