package com.lubuwei2.ssm.modules.employees;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lubuwei2.ssm.api.Api;
import com.lubuwei2.ssm.api.ApiGenerator;
import com.lubuwei2.ssm.api.PathConfig;
import com.lubuwei2.ssm.entity.Employee;
import com.lubuwei2.ssm.modules.employees.dto.EmployeesResult;
import com.lubuwei2.ssm.utils.pagination.PageList;
import com.lubuwei2.ssm.utils.pagination.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = PathConfig.API_EMPLOYEES)
public class EmployeesController {

    @Autowired
    EmployeesLogic logic;

    @Autowired
    EmployeesService service;

    @GetMapping("list")
    public Api<PageList<EmployeesResult>> list() {
        // 参数设置
        PageUtils.setPage(1, 10);
        Employee employee = new Employee();
        // 调用服务
        List<EmployeesResult> list = service.find(employee);
        // 分页
        PageList<EmployeesResult> pageList = PageUtils.create(list);

        return ApiGenerator.ok(pageList);
    }
}
