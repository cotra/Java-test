package com.lubuwei2.ssm.api;

public class PathConfig {
    // 前缀
    private static final String PREFIX = "api";
    // api地址
    private static final String API_V1 = PREFIX + "/v1/";
    // 用户功能集
    public static final String API_USER = API_V1 + "user/";
    // 订单功能集
    public static final String API_ORDER = API_V1 + "order/";
    // 验证功能集
    public static final String API_VERIFICATION = API_V1 + "verification/";
}
