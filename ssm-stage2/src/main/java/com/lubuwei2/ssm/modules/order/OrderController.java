package com.lubuwei2.ssm.modules.order;

import com.lubuwei2.ssm.api.Api;
import com.lubuwei2.ssm.api.ApiGenerator;
import com.lubuwei2.ssm.api.PathConfig;
import com.lubuwei2.ssm.entity.Order;
import com.lubuwei2.ssm.modules.order.domain.OrderBasicResult;
import com.lubuwei2.ssm.modules.order.dto.Flag;
import com.lubuwei2.ssm.modules.order.dto.OrderFind;
import com.lubuwei2.ssm.modules.user.domain.UserRegisterRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = PathConfig.API_ORDER)
public class OrderController {

    @Autowired
    OrderService service;

    @GetMapping("list")
    public Api<List<OrderBasicResult>> list() {
        OrderFind dto = service.find(new Order());
        if(dto.getFlag() == Flag.OK) {
            return ApiGenerator.ok(dto.getOrder());
        }
        // 默认
        return ApiGenerator.fail();
    }
}
