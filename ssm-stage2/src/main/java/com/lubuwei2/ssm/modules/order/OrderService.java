package com.lubuwei2.ssm.modules.order;

import com.lubuwei2.ssm.entity.Order;
import com.lubuwei2.ssm.modules.order.domain.OrderBasicResult;
import com.lubuwei2.ssm.modules.order.dto.Flag;
import com.lubuwei2.ssm.modules.order.dto.OrderFind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class OrderService {
    @Autowired
    private OrderDao dao;

    public OrderFind find(Order order) {
        OrderFind dto = new OrderFind();

        List<OrderBasicResult> list = dao.find(order);
        if (list != null) {
            dto.setFlag(Flag.OK);
            dto.setOrder(list);
        }
        return dto;
    }
}
