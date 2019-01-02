package com.lubuwei2.ssm.security.filter;

import com.lubuwei2.ssm.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AppAuthenticationFilter extends OncePerRequestFilter {

    @Value("${jwt.name}")
    private String tokenName;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        Authentication authentication = getAuthentication(req);
        // 设置对比项
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(authentication);
        // 继续
        filterChain.doFilter(req, res);
    }

    // 认证实现
    private Authentication getAuthentication(HttpServletRequest req) {
        // 获得token
        String token = req.getHeader(tokenName);
        if (token != null) {

        }
        System.out.println(token);
        return new UsernamePasswordAuthenticationToken("15012345678", MD5Utils.toMD5("123456"));
    }
}
