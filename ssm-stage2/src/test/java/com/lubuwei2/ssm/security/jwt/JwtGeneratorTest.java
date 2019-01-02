package com.lubuwei2.ssm.security.jwt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

public class JwtGeneratorTest {

    @Test
    public void create() {
        String s = JwtGenerator.create();
        System.out.println(s);
    }

    @Test
    public void read() {
        String token = JwtGenerator.create();
        JwtGenerator.read(token);
    }
}