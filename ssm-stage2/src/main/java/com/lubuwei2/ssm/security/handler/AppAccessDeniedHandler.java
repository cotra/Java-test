package com.lubuwei2.ssm.security.handler;

import com.lubuwei2.ssm.api.ApiGenerator;
import com.lubuwei2.ssm.api.Code;
import com.lubuwei2.ssm.utils.JsonUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AppAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest req, HttpServletResponse res, AccessDeniedException e) throws IOException, ServletException {
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        res.getWriter().write(JsonUtils.objToString(ApiGenerator.fail(Code.FAILURE_ACCESS_DENIED)));
        res.getWriter().flush();
    }
}
