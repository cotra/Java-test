package com.lubuwei.demojpa.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRepositoryTest {

    @Autowired
    TestRepository testRepository;

    @Test
    public void testGeneralMethod(){
        List<com.lubuwei.demojpa.entity.Test> list = testRepository.findAll();
        System.out.println(list.get(0).getName());
    }
}