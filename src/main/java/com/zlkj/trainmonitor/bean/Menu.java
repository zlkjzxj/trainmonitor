package com.zlkj.trainmonitor.bean;

import org.apache.ibatis.type.Alias;

@Alias("menu")
public class Menu {
    private String aid;
    private String label;
    private String apath;
    private String aorder;
    private String alevel;
    private String aurl;
    private String atype;
    private String astyle;
    private String disabled;

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getApath() {
        return apath;
    }

    public void setApath(String apath) {
        this.apath = apath;
    }

    public String getAorder() {
        return aorder;
    }

    public void setAorder(String aorder) {
        this.aorder = aorder;
    }

    public String getAlevel() {
        return alevel;
    }

    public void setAlevel(String alevel) {
        this.alevel = alevel;
    }

    public String getAurl() {
        return aurl;
    }

    public void setAurl(String aurl) {
        this.aurl = aurl;
    }

    public String getAtype() {
        return atype;
    }

    public void setAtype(String atype) {
        this.atype = atype;
    }

    public String getAstyle() {
        return astyle;
    }

    public void setAstyle(String astyle) {
        this.astyle = astyle;
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled;
    }
}
