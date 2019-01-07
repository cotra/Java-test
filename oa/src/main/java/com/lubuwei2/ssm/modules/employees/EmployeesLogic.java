package com.lubuwei2.ssm.modules.employees;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lubuwei2.ssm.utils.pagination.PageList;
import com.lubuwei2.ssm.modules.employees.dto.EmployeesResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeesLogic {
    public PageList<EmployeesResult> pagination(Integer pageNum, Integer pageSize, List<EmployeesResult> list) {
        PageInfo<EmployeesResult> pageInfo = new PageInfo<>(list);
        int size = pageInfo.getList().size();
        System.out.println(size);
        return null;
    }
}
