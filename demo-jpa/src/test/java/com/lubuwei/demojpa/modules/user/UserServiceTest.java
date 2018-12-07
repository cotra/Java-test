package com.lubuwei.demojpa.modules.user;

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
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void save() {
        User user = new User();
        user.setMobile("12312345");
        user.setPassword("666");
        user.setCreateTime(TimeUtils.dateToSqlTimestamp());
        user.setIsDelete(0);
        userService.save(user);
    }
}