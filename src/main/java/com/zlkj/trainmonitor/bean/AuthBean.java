package com.zlkj.trainmonitor.bean;

import org.apache.ibatis.type.Alias;

/**
 * bean：角色信息表
 */
@Alias("auth")
public class AuthBean {
    private String roleid;
    private String roledesc;
    private String rolepid;
    public AuthBean(){}
    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getRoledesc() {
        return roledesc;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc;
    }

    public String getRolepid() {
        return rolepid;
    }

    public void setRolepid(String rolepid) {
        this.rolepid = rolepid;
    }
}
