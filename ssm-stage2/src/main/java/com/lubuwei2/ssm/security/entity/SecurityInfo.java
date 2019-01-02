package com.lubuwei2.ssm.security.entity;

public class SecurityInfo {
    private String mobile;
    private String tokenPwd;

    public SecurityInfo(String mobile, String tokenPwd) {
        this.mobile = mobile;
        this.tokenPwd = tokenPwd;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTokenPwd() {
        return tokenPwd;
    }

    public void setTokenPwd(String tokenPwd) {
        this.tokenPwd = tokenPwd;
    }
}
