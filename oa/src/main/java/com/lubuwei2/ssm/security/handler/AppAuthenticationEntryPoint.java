package com.lubuwei2.ssm.security.handler;

import com.lubuwei2.ssm.api.ApiGenerator;
import com.lubuwei2.ssm.api.Code;
import com.lubuwei2.ssm.entity.User;
import com.lubuwei2.ssm.utils.JsonUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AppAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException e) throws IOException, ServletException {
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        res.getWriter().write(JsonUtils.objToString(ApiGenerator.fail(Code.FAILURE_TOKEN_ERROR)));
        res.getWriter().flush();
    }
}
