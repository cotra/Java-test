package com.lubuwei2.ssm.modules.order.dto;

import com.lubuwei2.ssm.modules.order.domain.OrderBasicResult;

import java.util.List;

public class OrderFind {
    private Integer flag;
    private List<OrderBasicResult> order;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public List<OrderBasicResult> getOrder() {
        return order;
    }

    public void setOrder(List<OrderBasicResult> order) {
        this.order = order;
    }
}
