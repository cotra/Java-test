package com.lubuwei.demojpa.modules.access.domain;

import javax.validation.constraints.NotBlank;

public class UserRegister {
    @NotBlank(message = "电话不能为空")
    private String mobile;
    @NotBlank(message = "密码不能为空")
    private String password;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
