package com.lubuwei2.ssm.utils;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegexUtilsTest {

    @Test
    public void checkDigit() {
        boolean digit = RegexUtils.checkDigit("5623");
        Assert.assertTrue(digit);
    }
}