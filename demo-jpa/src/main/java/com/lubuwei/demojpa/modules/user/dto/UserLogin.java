package com.lubuwei.demojpa.modules.user.dto;

import com.lubuwei.demojpa.entity.User;

public class UserLogin {
    private Integer flag;
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
