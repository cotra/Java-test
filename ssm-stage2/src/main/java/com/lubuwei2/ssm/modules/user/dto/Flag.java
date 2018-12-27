package com.lubuwei2.ssm.modules.user.dto;

public class Flag {
    // 成功
    public static final Integer OK = 0;
    // 已经存在这个手机号码的用户
    public static final Integer USER_EXISTS = -1;
    // 逻辑存在用户大于两个
    public static final Integer USER_MORE_ONE = -2;
    // 手机或密码错误
    public static final Integer MOBILE_OR_PASSWORD_ERROR = -3;
}
