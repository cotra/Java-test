package com.lubuwei2.ssm.modules.user;

import javax.servlet.http.HttpServletResponse;

class UserLogic {
    // 设置响应头
    static void setHeaders(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("image/jpeg");
    }

    // 返回响应图片
}
