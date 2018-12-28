package com.lubuwei2.ssm.modules.security.dto;

import com.lubuwei2.ssm.modules.security.domain.LoginRes;
import com.lubuwei2.ssm.modules.user.domain.UserBasicResult;

public class Login {
    private Integer flag;
    private LoginRes user;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public LoginRes getUser() {
        return user;
    }

    public void setUser(LoginRes user) {
        this.user = user;
    }
}
