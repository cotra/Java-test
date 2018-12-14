package com.lubuwei.demojpa.modules.access.dto;

public class UserRegister {
    private Integer flag = Flag.OK;
    private Long uid;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
}
