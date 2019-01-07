package com.lubuwei2.ssm.modules.employees;

import com.lubuwei2.ssm.entity.Employee;
import com.lubuwei2.ssm.modules.employees.dto.EmployeesResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeesServiceTest {

    @Autowired
    EmployeesService service;

    @Test
    public void find() {
        Employee employee = new Employee();
        List<EmployeesResult> list = service.find(employee);
        System.out.println(list.size());
        assertNotNull(list);
    }
}