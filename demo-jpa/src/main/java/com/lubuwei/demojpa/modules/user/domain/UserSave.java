package com.lubuwei.demojpa.modules.user.domain;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2018/9/6.
 */
public class UserSave {
    private String realName;
    private String nickname;
    private String mobile;
    private String email;
    private String password;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
