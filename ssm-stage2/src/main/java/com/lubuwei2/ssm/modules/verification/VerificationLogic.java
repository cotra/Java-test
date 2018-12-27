package com.lubuwei2.ssm.modules.verification;

import javax.servlet.http.HttpServletResponse;

class VerificationLogic {
    // 设置响应头
    static void setHeaders(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("image/jpeg");
    }

    // 返回响应图片
}
