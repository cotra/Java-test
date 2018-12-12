package com.lubuwei.demojpa.modules.user;

import com.lubuwei.demojpa.dao.UserDao;
import com.lubuwei.demojpa.entity.User;
import com.lubuwei.demojpa.utils.TimeUtils;
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
    public void testSave(){
        User user = new User();
        user.setMobile("7772227");
        user.setEmail("sdfsdf");
        user.setPassword("123123123123");
        user.setIsDelete(0);
        user.setCreateTime(TimeUtils.letDateToSqlTimestamp());
        userDao.save(user);
    }
}