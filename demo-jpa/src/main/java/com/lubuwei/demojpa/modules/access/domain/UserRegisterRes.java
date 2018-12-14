package com.lubuwei.demojpa.modules.access.domain;

public class UserRegisterRes {
    private Long uid;

    public UserRegisterRes(Long uid) {
        this.uid = uid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
}
