package com.lubuwei2.ssm.modules.order.domain;

import java.sql.Timestamp;

public class OrderBasicResult {
    private Long oid;
    private String mobile;
    private Timestamp createTime;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
