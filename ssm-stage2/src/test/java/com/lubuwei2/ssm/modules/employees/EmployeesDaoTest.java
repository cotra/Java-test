package com.lubuwei2.ssm.modules.employees;

import com.lubuwei2.ssm.entity.Employee;
import com.lubuwei2.ssm.modules.order.domain.OrderBasicResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeesDaoTest {

    @Autowired
    EmployeesDao dao;

    @Test
    public void find() {
        Employee employee = new Employee();
        List<OrderBasicResult> list = dao.find(employee);
        assertNotNull(list);
    }
}