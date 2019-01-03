package com.lubuwei2.ssm.modules.employees;

import com.lubuwei2.ssm.api.Api;
import com.lubuwei2.ssm.api.ApiGenerator;
import com.lubuwei2.ssm.api.PathConfig;
import com.lubuwei2.ssm.modules.order.domain.OrderBasicResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = PathConfig.API_EMPLOYEES)
public class EmployeesController {

    @GetMapping("list")
    public Api<List<OrderBasicResult>> list() {
        return ApiGenerator.fail();
    }
}
