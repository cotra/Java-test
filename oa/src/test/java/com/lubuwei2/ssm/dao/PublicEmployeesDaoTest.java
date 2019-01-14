package com.lubuwei2.ssm.dao;

import com.lubuwei2.ssm.entity.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PublicEmployeesDaoTest {

    @Autowired
    PublicEmployeesDao dao;

    @Test
    public void findByFlag() {
        List<Employee> list = dao.findByFlag("100");
        Assert.assertEquals(list.size(), 1);
    }
}