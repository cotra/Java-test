package com.lubuwei2.ssm.modules.employees;

import com.lubuwei2.ssm.entity.Employee;
import com.lubuwei2.ssm.modules.employees.dto.EmployeesResult;;
import com.lubuwei2.ssm.utils.pagination.PageList;
import com.lubuwei2.ssm.utils.pagination.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class EmployeesService {

    @Autowired
    EmployeesDao dao;

    @Cacheable(value = "employeesList")
    public PageList<EmployeesResult> find(Employee employee, Integer page, Integer rows) {
        PageUtils.setPage(page, rows);

        // 模糊查询
        if (employee.getRealName().trim().length() != 0) {
            employee.setRealName("%" + employee.getRealName() +"%");
        }

        List<EmployeesResult> list = dao.find(employee);

        PageList<EmployeesResult> pageList = PageUtils.create(list);
        return pageList;
    }
}
