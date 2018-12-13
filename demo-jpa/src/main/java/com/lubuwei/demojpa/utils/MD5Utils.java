package com.lubuwei.demojpa.utils;



import org.springframework.util.DigestUtils;

/**
 * Created by Administrator on 2018/9/6.
 */
public class MD5Utils {
    public static String toMD5(String str) {
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }
}
