package com.zlkj.trainmonitor.bean;

import org.apache.ibatis.type.Alias;

/**
 * bean：角色对应的资源表（资源就是我们说的programe）
 */
@Alias("authsources")
public class AuthSourcesBean {
    private String roleid;
    private String resid;
    private String restype;
    private String respermission;

    public AuthSourcesBean(){}
    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getResid() {
        return resid;
    }

    public void setResid(String resid) {
        this.resid = resid;
    }

    public String getRestype() {
        return restype;
    }

    public void setRestype(String restype) {
        this.restype = restype;
    }

    public String getRespermission() {
        return respermission;
    }

    public void setRespermission(String respermission) {
        this.respermission = respermission;
    }
}
