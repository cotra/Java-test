package com.lubuwei.demojpa.modules.access.dto;

import com.lubuwei.demojpa.entity.User;

public class UserLogin {
    private Integer flag = Flag.OK;
    private User user;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
