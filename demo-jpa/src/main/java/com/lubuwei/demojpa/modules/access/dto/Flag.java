package com.lubuwei.demojpa.modules.access.dto;

public class Flag {
    // 成功
    public static final Long OK = 0L;
    // 已经存在这个手机号码
    public static final Long MOBILE_EXISTS = -1L;
    // 逻辑存在用户大于两个
    public static final Long MOBILE_MORE_ONE = -2L;
    // 没有逻辑存在用户
    public static final Long MOBILE_NO = -3L;
}
