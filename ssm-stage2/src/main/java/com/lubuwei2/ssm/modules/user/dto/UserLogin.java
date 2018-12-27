package com.lubuwei2.ssm.modules.user.dto;

import com.lubuwei2.ssm.modules.user.domain.UserBasicResult;

public class UserLogin {
    private Integer flag;
    private UserBasicResult user;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public UserBasicResult getUser() {
        return user;
    }

    public void setUser(UserBasicResult user) {
        this.user = user;
    }
}
