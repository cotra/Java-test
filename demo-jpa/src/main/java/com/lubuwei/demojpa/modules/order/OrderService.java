package com.lubuwei.demojpa.modules.order;

import com.lubuwei.demojpa.dao.OrderDao;
import com.lubuwei.demojpa.entity.Order;
import com.lubuwei.demojpa.modules.order.dto.Flag;
import com.lubuwei.demojpa.modules.order.dto.OrderList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    // 获得订单列表
    OrderList list() {
        OrderList dto = new OrderList();

        List<Order> list = orderDao.findAll();
        dto.setList(list);
        dto.setFlag(Flag.OK);
        return dto;
    }
}
