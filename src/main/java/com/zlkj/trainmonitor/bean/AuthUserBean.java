package com.zlkj.trainmonitor.bean;

import org.apache.ibatis.type.Alias;

/**
 * bean:用户对应的角色ID表
 */
@Alias("authuser")
public class AuthUserBean {
    private String yhdh;
    private String roleid;

    public String getYhdh() {
        return yhdh;
    }

    public void setYhdh(String yhdh) {
        this.yhdh = yhdh;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }
}
