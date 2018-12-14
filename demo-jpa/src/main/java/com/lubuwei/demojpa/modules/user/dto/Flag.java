package com.lubuwei.demojpa.modules.user.dto;

public class Flag {
    // 成功
    public static final Integer OK = 0;
    // 已经存在这个手机号码
    public static final Integer USER_EXISTS = -1;
    // 逻辑存在用户大于两个
    public static final Integer USER_MORE_ONE = -2;
    // 没有逻辑存在用户
    public static final Integer MOBILE_NO = -3;
    // 密码错误
    public static final Integer PASSWORD_ERROR = -4;
}
