package com.lubuwei2.ssm.security.filter;

import com.lubuwei2.ssm.utils.MD5Utils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AppAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        Authentication request = getAuthentication(req);
        // 设置对比项
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(request);
        // 继续
        filterChain.doFilter(req, res);
    }

    // 验证方法
    private Authentication getAuthentication(HttpServletRequest req) {
        return new UsernamePasswordAuthenticationToken("15012345678", MD5Utils.toMD5("123456"));
    }
}
