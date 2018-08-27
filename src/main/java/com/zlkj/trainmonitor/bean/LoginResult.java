package com.zlkj.trainmonitor.bean;

public class LoginResult {
    private String status;
    private String type;
    private String currentAuthority;
    private CurrentUser currentUser;

    public LoginResult() {
    }

    public LoginResult(String status, String type, String currentAuthority, CurrentUser currentUser) {
        this.status = status;
        this.type = type;
        this.currentAuthority = currentAuthority;
        this.currentUser = currentUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCurrentAuthority() {
        return currentAuthority;
    }

    public void setCurrentAuthority(String currentAuthority) {
        this.currentAuthority = currentAuthority;
    }

    public CurrentUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

}
