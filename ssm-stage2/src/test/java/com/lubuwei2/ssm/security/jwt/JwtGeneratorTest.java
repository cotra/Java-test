package com.lubuwei2.ssm.security.jwt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtGeneratorTest {

    @Autowired
    JwtGenerator jwtGenerator;

    @Test
    public void create() {
        String s = jwtGenerator.create();
        System.out.println(s);
    }
}