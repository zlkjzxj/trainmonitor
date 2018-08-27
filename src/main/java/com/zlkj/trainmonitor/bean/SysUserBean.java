package com.zlkj.trainmonitor.bean;

import org.apache.ibatis.type.Alias;

/**
 * bean:用户表信息
 */
@Alias("sysuserbean")
public class SysUserBean {
    private String yhdh;
    private String mm;
    private String xm;
    private String bmdh;
    private String isexpired;
    private String islocked;
    private String iscredentialsexpired;
    private String isenabled;
    private String yhyxq;
    private String mmyxq;
    private String sfzmhm;
    private String lxdh;
    private String lxdz;
    private String ipstart;
    private String ipend;
    private String userdesc;
    private String csrq;
    private int key;

    public SysUserBean() {
    }

    public SysUserBean(String yhdh) {
        this.yhdh = yhdh;
    }

    public String getYhdh() {
        return yhdh;
    }

    public void setYhdh(String yhdh) {
        this.yhdh = yhdh;
    }

    public String getMm() {
        return mm;
    }

    public void setMm(String mm) {
        this.mm = mm;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getBmdh() {
        return bmdh;
    }

    public void setBmdh(String bmdh) {
        this.bmdh = bmdh;
    }

    public String getIsexpired() {
        return isexpired;
    }

    public void setIsexpired(String isexpired) {
        this.isexpired = isexpired;
    }

    public String getIslocked() {
        return islocked;
    }

    public void setIslocked(String islocked) {
        this.islocked = islocked;
    }

    public String getIscredentialsexpired() {
        return iscredentialsexpired;
    }

    public void setIscredentialsexpired(String iscredentialsexpired) {
        this.iscredentialsexpired = iscredentialsexpired;
    }

    public String getIsenabled() {
        return isenabled;
    }

    public void setIsenabled(String isenabled) {
        this.isenabled = isenabled;
    }

    public String getYhyxq() {
        return yhyxq;
    }

    public void setYhyxq(String yhyxq) {
        this.yhyxq = yhyxq;
    }

    public String getMmyxq() {
        return mmyxq;
    }

    public void setMmyxq(String mmyxq) {
        this.mmyxq = mmyxq;
    }

    public String getSfzmhm() {
        return sfzmhm;
    }

    public void setSfzmhm(String sfzmhm) {
        this.sfzmhm = sfzmhm;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public String getLxdz() {
        return lxdz;
    }

    public void setLxdz(String lxdz) {
        this.lxdz = lxdz;
    }

    public String getIpstart() {
        return ipstart;
    }

    public void setIpstart(String ipstart) {
        this.ipstart = ipstart;
    }

    public String getIpend() {
        return ipend;
    }

    public void setIpend(String ipend) {
        this.ipend = ipend;
    }

    public String getUserdesc() {
        return userdesc;
    }

    public void setUserdesc(String userdesc) {
        this.userdesc = userdesc;
    }

    public String getCsrq() {
        return csrq;
    }

    public void setCsrq(String csrq) {
        this.csrq = csrq;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
