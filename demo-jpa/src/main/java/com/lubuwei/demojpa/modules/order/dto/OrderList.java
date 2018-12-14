package com.lubuwei.demojpa.modules.order.dto;

import com.lubuwei.demojpa.entity.Order;

import java.util.List;

public class OrderList {
    private Integer flag;
    private List<Order> list;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public List<Order> getList() {
        return list;
    }

    public void setList(List<Order> list) {
        this.list = list;
    }
}
