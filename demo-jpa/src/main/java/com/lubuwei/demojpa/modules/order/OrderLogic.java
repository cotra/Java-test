package com.lubuwei.demojpa.modules.order;

import com.lubuwei.demojpa.api.Api;
import com.lubuwei.demojpa.api.ApiGenerator;
import com.lubuwei.demojpa.entity.Order;
import com.lubuwei.demojpa.modules.order.dto.Flag;
import com.lubuwei.demojpa.modules.order.dto.OrderList;
import org.springframework.beans.BeanUtils;

import java.util.List;

class OrderLogic {

    // 对象属性生成
    static Order ToOrder(Object req) {
        Order order = new Order();
        BeanUtils.copyProperties(req, order);
        return order;
    }

    // 对象属性生成
//    static OrderListRes ToUserLoginRes(User user) {
//        UserLoginRes res = new UserLoginRes();
//        BeanUtils.copyProperties(user, res);
//        return res;
//    }

    // 订单列表api
    static Api<List<Order>> listApi(OrderList dto) {
        Integer flag = dto.getFlag();
        // 失败返回
        // 成功返回
        if (flag == Flag.OK) {

            return ApiGenerator.ok(dto.getList());
        }
        return ApiGenerator.fail();
    }
}
