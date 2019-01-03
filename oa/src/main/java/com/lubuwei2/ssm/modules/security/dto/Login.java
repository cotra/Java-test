package com.lubuwei2.ssm.modules.security.dto;


public class Login {
    private Integer flag;
    private FindResult user;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public FindResult getUser() {
        return user;
    }

    public void setUser(FindResult user) {
        this.user = user;
    }
}
