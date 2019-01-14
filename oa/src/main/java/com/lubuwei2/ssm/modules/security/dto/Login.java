package com.lubuwei2.ssm.modules.security.dto;

public class Login {
    private Integer flag;
    private LoginResult result;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public LoginResult getResult() {
        return result;
    }

    public void setResult(LoginResult result) {
        this.result = result;
    }
}
