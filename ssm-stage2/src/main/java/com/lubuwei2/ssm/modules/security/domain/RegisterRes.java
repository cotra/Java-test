package com.lubuwei2.ssm.modules.security.domain;

import java.io.Serializable;

public class RegisterRes implements Serializable {
    private Long uid;

    public RegisterRes(Long uid) {
        this.uid = uid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
}
