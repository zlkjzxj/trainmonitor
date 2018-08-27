package com.zlkj.trainmonitor.bean;

import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * bean：管理部门表
 */
@Alias("department")
public class DepartmentBean {
    private  String bmdh;//部门代号
    private  String bmmc;//部门名称
    private  String bmjb;//部门级别
    private  String bmpid;//上级部门
    private  String bmalisaid;//部门id别名
    private  String bmjc;//部门简称
    private  String bmdtmc;//部门地图名称
    private  String bmdtzb	;//部门地图坐标
    private  String bmpyzb	;//部门地图偏移坐标
    private  String bmdtjc	;//部门地图标注简称
    private  String fzjg;//发证机关
    private  String kybj;//可用标记

    public String getKybj() {
        return kybj;
    }

    public void setKybj(String kybj) {
        this.kybj = kybj;
    }

    public List<DepartmentBean> getChildList() {
        return childList;
    }

    public void setChildList(List<DepartmentBean> childList) {
        this.childList = childList;
    }

    private List<DepartmentBean> childList;

    public DepartmentBean(){}
    public String getBmdh() {
        return bmdh;
    }

    public void setBmdh(String bmdh) {
        this.bmdh = bmdh;
    }

    public String getBmmc() {
        return bmmc;
    }

    public void setBmmc(String bmmc) {
        this.bmmc = bmmc;
    }

    public String getBmjb() {
        return bmjb;
    }

    public void setBmjb(String bmjb) {
        this.bmjb = bmjb;
    }

    public String getBmpid() {
        return bmpid;
    }

    public void setBmpid(String bmpid) {
        this.bmpid = bmpid;
    }

    public String getBmalisaid() {
        return bmalisaid;
    }

    public void setBmalisaid(String bmalisaid) {
        this.bmalisaid = bmalisaid;
    }

    public String getBmjc() {
        return bmjc;
    }

    public void setBmjc(String bmjc) {
        this.bmjc = bmjc;
    }

    public String getBmdtmc() {
        return bmdtmc;
    }

    public void setBmdtmc(String bmdtmc) {
        this.bmdtmc = bmdtmc;
    }

    public String getBmdtzb() {
        return bmdtzb;
    }

    public void setBmdtzb(String bmdtzb) {
        this.bmdtzb = bmdtzb;
    }

    public String getBmpyzb() {
        return bmpyzb;
    }

    public void setBmpyzb(String bmpyzb) {
        this.bmpyzb = bmpyzb;
    }

    public String getBmdtjc() {
        return bmdtjc;
    }

    public void setBmdtjc(String bmdtjc) {
        this.bmdtjc = bmdtjc;
    }

    public String getFzjg() {
        return fzjg;
    }

    public void setFzjg(String fzjg) {
        this.fzjg = fzjg;
    }
}
