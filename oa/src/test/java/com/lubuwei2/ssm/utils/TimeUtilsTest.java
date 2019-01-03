package com.lubuwei2.ssm.utils;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class TimeUtilsTest {

    @Test
    public void addOneYear() {
        Date date = TimeUtils.addMonths(13);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}