package com.lubuwei2.ssm.modules.employees;

import com.lubuwei2.ssm.entity.Employee;
import com.lubuwei2.ssm.modules.employees.dto.EmployeesResult;
import com.lubuwei2.ssm.utils.TimeUtils;
import com.sun.media.sound.SoftTuning;
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
    public void count() {
        Long count = dao.count();
        System.out.println(count);
    }

    @Test
    public void deleteBatch() {
        Employee employee1 = new Employee();
        employee1.setEid(3L);
        Employee employee2 = new Employee();
        employee2.setEid(4L);

        List<Employee> list = new ArrayList<>();
        list.add(employee1);
        list.add(employee2);
        Integer flag = dao.deleteBatch(list);
        System.out.println(flag);
    }

    @Test
    public void delete() {
        Employee employee = new Employee();
        employee.setEid(2L);
        Integer logicDelete = dao.delete(employee);
        System.out.println(logicDelete);
    }

    @Test
    public void logicDeleteBatch() {
        Employee employee1 = new Employee();
        employee1.setEid(1L);
        Employee employee2 = new Employee();
        employee2.setEid(2L);

        List<Employee> list = new ArrayList<>();
        list.add(employee1);
        list.add(employee2);
        Integer flag = dao.logicDeleteBatch(list);
        System.out.println(flag);
    }

    @Test
    public void logicDelete() {
        Employee employee = new Employee();
        employee.setEid(2L);
        Integer logicDelete = dao.logicDelete(employee);
        System.out.println(logicDelete);
    }

    @Test
    public void updateBatch() {
        Employee employee1 = new Employee();
        employee1.setRealName("hte1");
        employee1.setEid(1L);

        Employee employee2 = new Employee();
        employee2.setRealName("htt2");
        employee2.setEid(2L);

        List<Employee> list = new ArrayList<>();
        list.add(employee1);
        list.add(employee2);
        Integer flag = dao.updateBatch(list);
    }

    @Test
    public void update() {
        Employee employee = new Employee();
        employee.setRealName("sdf12131");
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

    @Test
    public void find() {
        Employee employee = new Employee();
        List<EmployeesResult> list = dao.find(employee);
        System.out.println(list.size());
        assertNotNull(list);
    }

    @Test
    public void findByPK() {
        EmployeesResult result = dao.findByPK(5L);
        System.out.println(result.getFirstName());
    }

    private Employee createEntity() {
        Employee employee = new Employee();
        employee.setEmpNo("100");
        employee.setRealName("tet");
        employee.setBirthDate(TimeUtils.letDateToSqlDate());
        employee.setGender(1);
        employee.setMobile("15008260209");
        employee.setHireDate(TimeUtils.letDateToSqlDate());


        return employee;
    }
}