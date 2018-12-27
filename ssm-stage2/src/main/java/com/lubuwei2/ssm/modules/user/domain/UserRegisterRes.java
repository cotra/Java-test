package com.lubuwei2.ssm.modules.user.domain;

import java.io.Serializable;

public class UserRegisterRes implements Serializable {
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
