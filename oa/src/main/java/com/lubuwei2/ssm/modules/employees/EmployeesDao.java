package com.lubuwei2.ssm.modules.employees;

import com.lubuwei2.ssm.domain.BasicMapper;
import com.lubuwei2.ssm.domain.FindMapper;
import com.lubuwei2.ssm.entity.Employee;
import com.lubuwei2.ssm.modules.employees.dto.EmployeesResult;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EmployeesDao extends BasicMapper<Employee>, FindMapper<Employee, EmployeesResult> {
}
