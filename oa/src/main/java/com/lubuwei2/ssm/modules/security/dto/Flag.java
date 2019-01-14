package com.lubuwei2.ssm.modules.security.dto;

public class Flag {
    // 成功
    public static final Integer OK = 0;
    // 已经存在这个手机号码的用户
    public static final Integer USER_EXISTS = -1;
    // 用户不是唯一
    public static final Integer USER_MORE_ONE = -2;
    // 用户或密码错误
    public static final Integer ACCOUNT_OR_PASSWORD_ERROR = -3;
}
