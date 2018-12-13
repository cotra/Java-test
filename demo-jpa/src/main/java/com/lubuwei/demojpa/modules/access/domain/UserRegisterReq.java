package com.lubuwei.demojpa.modules.access.domain;

public class UserRegisterReq {
    private Long uid;

    public UserRegisterReq(Long uid) {
        this.uid = uid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
}
