package com.lubuwei2.ssm.modules.security.dto;

import com.lubuwei2.ssm.modules.security.domain.LoginRes;

public class Login {
    private String flag;
    private LoginRes res;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public LoginRes getRes() {
        return res;
    }

    public void setRes(LoginRes res) {
        this.res = res;
    }
}
