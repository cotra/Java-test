package com.lubuwei2.ssm.modules.user;

import com.lubuwei2.ssm.entity.User;
import com.lubuwei2.ssm.modules.user.domain.UserBasicResult;
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
    public void findTest() {
        User user = new User();
        List<UserBasicResult> list = userDao.find(user);
        System.out.println("lu_user表中现有用户记录数: " + list.size());
        assertNotNull(list);
    }

    @Test
    public void findByMobile() {
        User user = new User();
        user.setMobile("15012345678");
        List<UserBasicResult> list = userDao.findByMobile(user);
        System.out.println(list.size());
        assertNotNull(list);
    }
}