package com.lubuwei2.ssm.modules.security;

import com.lubuwei2.ssm.modules.security.dto.Login;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityServiceTest {

    @Autowired
    SecurityService service;

    @Test
    public void login() {
        Login login = service.login("100", "123456");
        System.out.println(login.getFlag() + " | " + login.getRes().getRealName());
    }
}