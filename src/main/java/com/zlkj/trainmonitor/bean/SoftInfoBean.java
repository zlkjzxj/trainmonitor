package com.zlkj.trainmonitor.bean;


import org.apache.ibatis.type.Alias;

/**
 * bean:软件信息表
 */
@Alias("softinfo")
public class SoftInfoBean {
    private String ywxh	;//yyyymmddhh24miss
    private String softversion;//软件版本
    private String softname	;//软件名称
    private String softdesc	;//	软件描述
    private String softupdesc	;//软件更新描述
    private String softupbj	;//更新标记0、未更新1、已更新
    private String softupsj;//更新时间

    public SoftInfoBean(){}
    public String getYwxh() {
        return ywxh;
    }

    public void setYwxh(String ywxh) {
        this.ywxh = ywxh;
    }

    public String getSoftversion() {
        return softversion;
    }

    public void setSoftversion(String softversion) {
        this.softversion = softversion;
    }

    public String getSoftname() {
        return softname;
    }

    public void setSoftname(String softname) {
        this.softname = softname;
    }

    public String getSoftdesc() {
        return softdesc;
    }

    public void setSoftdesc(String softdesc) {
        this.softdesc = softdesc;
    }

    public String getSoftupdesc() {
        return softupdesc;
    }

    public void setSoftupdesc(String softupdesc) {
        this.softupdesc = softupdesc;
    }

    public String getSoftupbj() {
        return softupbj;
    }

    public void setSoftupbj(String softupbj) {
        this.softupbj = softupbj;
    }

    public String getSoftupsj() {
        return softupsj;
    }

    public void setSoftupsj(String softupsj) {
        this.softupsj = softupsj;
    }
}
