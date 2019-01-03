package com.lubuwei2.ssm.security.filter;

import com.lubuwei2.ssm.security.jwt.JwtGenerator;
import com.lubuwei2.ssm.utils.MD5Utils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    JwtGenerator jwt;

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
        // 获得token字符串
        String token = req.getHeader(tokenName);
        if (token != null) {
            // 验证是否是有效token
            Jws<Claims> claimsJws = jwt.read(token);
            if(claimsJws != null) {
                Claims body = claimsJws.getBody();
                // 电话号码
                String mobile = body.getAudience();
                // 授权时间
                long time = body.getIssuedAt().getTime();
                return new UsernamePasswordAuthenticationToken(mobile, time);
            }
            return null;
        }
        return null;
    }
}
