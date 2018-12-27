package com.lubuwei2.ssm.utils;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

/**
 * Created by Administrator on 2018/9/6.
 */
public class TimeUtils {

    /**
     * Date转sql的Timestamp
     */
    public static Timestamp letDateToSqlTimestamp() {
        Date date = new Date();
        return new Timestamp(date.getTime());
    }
}
