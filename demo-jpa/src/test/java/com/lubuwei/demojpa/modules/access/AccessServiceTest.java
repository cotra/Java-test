package com.lubuwei.demojpa.modules.access;

import com.lubuwei.demojpa.entity.User;
import com.lubuwei.demojpa.modules.access.dto.Flag;
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
    public void register() {
        User user = new User();
        user.setMobile("15012345678");
        user.setPassword("123456");
        Long register = accessService.register(user);
        assertEquals(register, Flag.MOBILE_EXISTS);
    }
}