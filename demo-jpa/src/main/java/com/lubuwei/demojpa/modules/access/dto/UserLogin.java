package com.lubuwei.demojpa.modules.access.dto;

import com.lubuwei.demojpa.entity.User;

public class UserLogin {
    private Long flag;
    private User user;

    public Long getFlag() {
        return flag;
    }

    public void setFlag(Long flag) {
        this.flag = flag;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
