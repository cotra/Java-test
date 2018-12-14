package com.lubuwei.demojpa.modules.order;

import com.lubuwei.demojpa.api.Api;
import com.lubuwei.demojpa.api.ApiGenerator;
import com.lubuwei.demojpa.api.PathConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = PathConfig.API_ORDER)
public class OrderController {

    @GetMapping("list")
    public Api<String> list () {
        // 合并到实体对象
        return ApiGenerator.ok();
    }
}
