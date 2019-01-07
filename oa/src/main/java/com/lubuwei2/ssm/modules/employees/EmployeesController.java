package com.lubuwei2.ssm.modules.employees;

import com.lubuwei2.ssm.api.Api;
import com.lubuwei2.ssm.api.ApiGenerator;
import com.lubuwei2.ssm.api.PathConfig;
import com.lubuwei2.ssm.entity.Employee;
import com.lubuwei2.ssm.modules.employees.domain.FindReq;
import com.lubuwei2.ssm.modules.employees.dto.EmployeesResult;
import com.lubuwei2.ssm.utils.ListUtils;
import com.lubuwei2.ssm.utils.pagination.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = PathConfig.API_EMPLOYEES)
public class EmployeesController {

    @Autowired
    EmployeesService service;

    @PostMapping("list")
    public Api<PageList<EmployeesResult>> list(@RequestBody @Validated FindReq req) {
        Employee employee = ListUtils.entityToModel(req, Employee.class);
        // 调用服务
        PageList<EmployeesResult> pageList = service.find(employee, req.getPage(), req.getRows());
        // 返回
        return ApiGenerator.ok(pageList);
    }
}
