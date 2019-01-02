package com.lubuwei2.ssm.security.entity;

import java.io.Serializable;
import java.util.Date;

public class SecurityInfo implements Serializable {
    private String mobile;
    private Date iat;

    public SecurityInfo(String mobile, Date iat) {
        this.mobile = mobile;
        this.iat = iat;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getIat() {
        return iat;
    }

    public void setIat(Date iat) {
        this.iat = iat;
    }
}
