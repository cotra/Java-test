package com.lubuwei.demojpa.modules.order;

import com.lubuwei.demojpa.api.Api;
import com.lubuwei.demojpa.api.ApiGenerator;
import com.lubuwei.demojpa.api.PathConfig;
import com.lubuwei.demojpa.entity.Order;
import com.lubuwei.demojpa.modules.order.dto.OrderList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = PathConfig.API_ORDER)
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("list")
    public Api<List<Order>> list() {
        // 合并到实体对象
        // 调用服务
        OrderList list = orderService.list();
        // 生成api
        Api<List<Order>> api = OrderLogic.listApi(list);
        return api;
    }
}
