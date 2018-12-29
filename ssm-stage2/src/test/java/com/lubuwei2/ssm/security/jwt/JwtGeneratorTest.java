package com.lubuwei2.ssm.security.jwt;

import org.junit.Test;

import static org.junit.Assert.*;

public class JwtGeneratorTest {

    @Test
    public void create() {
        String s = JwtGenerator.create();
        System.out.println(s);
    }
}