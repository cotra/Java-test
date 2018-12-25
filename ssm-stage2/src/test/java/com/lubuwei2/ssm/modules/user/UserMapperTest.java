package com.lubuwei2.ssm.modules.user;

import com.lubuwei2.ssm.entity.User;
import com.lubuwei2.ssm.modules.user.domain.UserBasicResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    UserDao userMapper;

    @Test
    public void findTest() {
        User user = new User();
        List<UserBasicResult> list = userMapper.find(user);
        System.out.println(list.size());
    }
}