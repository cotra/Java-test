package com.lubuwei2.ssm.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.sql.Timestamp;

@Alias("Account")
public class Account implements Serializable {
    private Long eid;
    private String username;
    private String password;
    private Timestamp createTime;
    private Timestamp lastLoginTime;

    public Account() {
    }

    public Account(String username, String password, Timestamp lastLoginTime) {
        this.username = username;
        this.password = password;
        this.lastLoginTime = lastLoginTime;
    }

    public Account(Long eid, String password, Timestamp lastLoginTime) {
        this.eid = eid;
        this.password = password;
        this.lastLoginTime = lastLoginTime;
    }

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
