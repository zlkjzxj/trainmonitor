package com.zlkj.trainmonitor.bean;

public class CurrentUser {
    private String name;
    private String avatar;
    private String userid;
    private Integer notifyCount;

    public CurrentUser() {
    }

    public CurrentUser(String name, String avatar, String userid, Integer notifyCount) {
        this.name = name;
        this.avatar = avatar;
        this.userid = userid;
        this.notifyCount = notifyCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getNotifyCount() {
        return notifyCount;
    }

    public void setNotifyCount(Integer notifyCount) {
        this.notifyCount = notifyCount;
    }
}
