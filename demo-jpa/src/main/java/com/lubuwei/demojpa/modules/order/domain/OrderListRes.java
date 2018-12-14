package com.lubuwei.demojpa.modules.order.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class OrderListRes implements Serializable {
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
