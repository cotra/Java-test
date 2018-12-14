package com.lubuwei.demojpa.modules.order;

import com.lubuwei.demojpa.api.Api;
import com.lubuwei.demojpa.api.ApiGenerator;
import com.lubuwei.demojpa.entity.Order;
import com.lubuwei.demojpa.modules.order.domain.OrderListRes;
import com.lubuwei.demojpa.modules.order.dto.Flag;
import com.lubuwei.demojpa.modules.order.dto.OrderList;
import com.lubuwei.demojpa.utils.ListUtils;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

class OrderLogic {

    // 订单列表api
    static Api<List<OrderListRes>> listApi(OrderList dto) {
        Integer flag = dto.getFlag();
        // 失败返回
        // 成功返回
        if (flag == Flag.OK) {
            List<OrderListRes> list = ListUtils.entityListToModelList(dto.getList(), OrderListRes.class);
            return ApiGenerator.ok(list);
        }
        return ApiGenerator.fail();
    }
}
