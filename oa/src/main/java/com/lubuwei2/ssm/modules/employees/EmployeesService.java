package com.lubuwei2.ssm.modules.employees;

import com.lubuwei2.ssm.entity.Employee;
import com.lubuwei2.ssm.modules.employees.dto.EmployeesResult;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class EmployeesService {

    @Autowired
    EmployeesDao dao;

    @Cacheable(value = "employeesList")
    public List<EmployeesResult> find(Employee employee) {
        List<EmployeesResult> list = dao.find(employee);
        return list;
    }
}
