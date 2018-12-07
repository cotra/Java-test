package com.lubuwei.demojpa.modules.user;

import com.lubuwei.demojpa.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    UserDao userDao;

    @Test
    public void testGeneralMethod(){
        List<User> list = userDao.findAll();
        int size = list.size();
        assertEquals(size, 0);
    }
}