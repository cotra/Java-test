package com.lubuwei.demojpa.modules.access;

import com.lubuwei.demojpa.entity.User;
import com.lubuwei.demojpa.utils.TimeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccessServiceTest {

    @Autowired
    AccessService accessService;

    @Test
    public void adminLogin() {
        User user = new User();
        user.setMobile("77722277745");
        user.setEmail("sdfsdf");
        user.setPassword("123123123123");
        user.setIsDelete(0);
        Long login = accessService.adminLogin(user);
        System.out.println(login);
    }
}