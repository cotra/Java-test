package com.lubuwei2.ssm.modules.user;

import com.lubuwei2.ssm.entity.User;
import com.lubuwei2.ssm.modules.user.domain.UserBasicResult;
import com.lubuwei2.ssm.utils.MD5Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.security.provider.MD5;

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
        assertNotNull(list);
    }

    @Test
    public void findByMobileTest() {
        User user = new User();
        user.setMobile("15012345678");
        List<UserBasicResult> list = userDao.findByMobile(user);
        assertNotNull(list);
    }

    @Test
    public void findByMobileAndPasswordTest() {
        User user = new User();
        user.setMobile("15012345678");
        user.setPassword(MD5Utils.toMD5("123456"));
        List<UserBasicResult> list = userDao.findByMobileAndPassword(user);
        System.out.println(list.size());
        assertNotNull(list);
    }
}