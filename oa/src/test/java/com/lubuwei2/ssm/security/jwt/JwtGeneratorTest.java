package com.lubuwei2.ssm.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtGeneratorTest {

    @Autowired
    JwtGenerator jwt;

    @Test
    public void create() {
        String s = jwt.create("15012345678", new Date());
    }

    @Test
    public void read() {
        String s = jwt.create("15012345678", new Date());
        Jws<Claims> jws = jwt.read(s);
    }
}