package com.lubuwei2.ssm.modules.security;

import com.lubuwei2.ssm.entity.Account;
import com.lubuwei2.ssm.utils.MD5Utils;
import com.lubuwei2.ssm.utils.TimeUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityDaoTest {

    @Autowired
    SecurityDao dao;

    @Test
    public void updateByEidAndPwd() {
        Account account = new Account();
        account.setEid(10L);
        account.setPassword(MD5Utils.toMD5("123456"));
        account.setLastLoginTime(TimeUtils.letDateToSqlTimestamp());
        Integer update = dao.updateByEidAndPwd(account);
        Assert.assertNotNull(update);
    }

    @Test
    public void updateByMobileAndPassword() {
        Account account = new Account();
        account.setUsername("super");
        account.setPassword(MD5Utils.toMD5("123456"));
        account.setLastLoginTime(TimeUtils.letDateToSqlTimestamp());
        Integer update = dao.updateByUsernameAndPwd(account);
        Assert.assertNotNull(update);
    }
}