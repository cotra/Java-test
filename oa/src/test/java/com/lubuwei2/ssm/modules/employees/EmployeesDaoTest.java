package com.lubuwei2.ssm.modules.employees;

import com.lubuwei2.ssm.entity.Employee;
import com.lubuwei2.ssm.modules.employees.dto.EmployeesResult;
import com.lubuwei2.ssm.utils.TimeUtils;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
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
        List<EmployeesResult> list = dao.find(employee);
        System.out.println(list.size());
        assertNotNull(list);
    }

    @Test
    public void updateBatch() {
        Employee employee1 = new Employee();
        employee1.setFirstName("ht");
        employee1.setEid(1L);

        Employee employee2 = new Employee();
        employee2.setFirstName("ht");
        employee2.setEid(2L);

        List<Employee> list = new ArrayList<>();
        list.add(employee1);
        list.add(employee2);
        Integer flag = dao.updateBatch(list);
    }

    @Test
    public void update() {
        Employee employee = new Employee();
        employee.setFirstName("sdf12131");
        employee.setEid(1L);
        List<Employee> list = new ArrayList<>();
        list.add(employee);
        dao.update(employee);
    }

    @Test
    public void saveBatch() {
        Employee employee = createEntity();

        List<Employee> list = new ArrayList<>();
        list.add(employee);
        list.add(employee);
        list.add(employee);
        Integer saveBatch = dao.saveBatch(list);
        assertNotNull(saveBatch);
    }

    @Test
    public void save() {
        Employee employee = createEntity();
        dao.save(employee);
    }

    private Employee createEntity() {
        Employee employee = new Employee();
        employee.setEmpNo("100056000");
        employee.setBirthDate(TimeUtils.letDateToSqlDate());
        employee.setHireDate(TimeUtils.letDateToSqlDate());
        employee.setFirstName("tet");
        employee.setLastName("dgd");
        employee.setGender(1);
        return employee;
    }
}