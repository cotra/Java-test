package com.lubuwei2.ssm.utils;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Administrator on 2018/9/6.
 */
public class TimeUtils {

    // Date转sql的Timestamp
    public static Timestamp letDateToSqlTimestamp() {
        Date date = new Date();
        return new Timestamp(date.getTime());
    }

    public static Date addMonths(int months) {
        Date date = new Date();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, months);
        date = calendar.getTime();
        return date;
    }
}
