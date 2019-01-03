package com.lubuwei2.ssm.modules.security;

import com.lubuwei2.ssm.entity.User;
import com.lubuwei2.ssm.utils.MD5Utils;
import com.lubuwei2.ssm.utils.TimeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityDaoTest {

    @Autowired
    SecurityDao dao;

    @Test
    public void updateByMobileAndPassword() {
        User user = new User();
        user.setMobile("15012345678");
        user.setPassword(MD5Utils.toMD5("123456"));
        user.setLastLoginTime(TimeUtils.letDateToSqlTimestamp());
        Integer update = dao.updateByMobileAndPassword(user);
        System.out.println(update);
//        assertNotNull(list);
    }
}