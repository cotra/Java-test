package com.lubuwei.demojpa.modules.user.domain;

import javax.validation.constraints.NotBlank;

public class UserLoginReq {
    @NotBlank(message = "电话不能为空")
    private String mobile;
    @NotBlank(message = "密码能为空")
    private String password;
    @NotBlank(message = "验证码能为空")
    private String code;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
