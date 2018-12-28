package com.lubuwei2.ssm.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //请求拦截
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // 禁止csrf
        HttpSecurity security = httpSecurity.csrf().disable();
        // 异常处理
        HttpSecurity role = security.exceptionHandling().authenticationEntryPoint(new AppAuthenticationEntryPoint()).accessDeniedHandler(new AppAccessDeniedHandler()).and();        // 权限设置
        role.authorizeRequests().antMatchers("/api/v1/user/security/*", "api/v1/verification/*").permitAll()
                .antMatchers("/api/v1/order/**").authenticated();
    }

}
