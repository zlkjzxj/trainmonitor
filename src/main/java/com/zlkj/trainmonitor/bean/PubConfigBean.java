package com.zlkj.trainmonitor.bean;

import org.apache.ibatis.type.Alias;

/**
 * bean:系统参数表
 */
@Alias("pubconfig")
public class PubConfigBean {
    private String csmc;
    private String csz;

    public String getCsmc() {
        return csmc;
    }

    public void setCsmc(String csmc) {
        this.csmc = csmc;
    }

    public String getCsz() {
        return csz;
    }

    public void setCsz(String csz) {
        this.csz = csz;
    }
}
