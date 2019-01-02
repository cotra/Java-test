package com.lubuwei2.ssm.security;

import com.lubuwei2.ssm.api.PathConfig;
import com.lubuwei2.ssm.security.filter.AppAuthenticationFilter;
import com.lubuwei2.ssm.security.service.AppUserDetailsService;
import com.lubuwei2.ssm.security.handler.AppAccessDeniedHandler;
import com.lubuwei2.ssm.security.handler.AppAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AppUserDetailsService appUserDetailsService;

    @Autowired
    private AppAuthenticationFilter appAuthenticationFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(appUserDetailsService);
    }

    //请求拦截
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // 禁止csrf
        HttpSecurity security = httpSecurity.csrf().disable().formLogin().disable();
        // 自定义异常处理
        HttpSecurity handler = security.exceptionHandling().authenticationEntryPoint(new AppAuthenticationEntryPoint()).accessDeniedHandler(new AppAccessDeniedHandler()).and();
        // 规则
        HttpSecurity role = handler.authorizeRequests().antMatchers(PathConfig.API_SECURITY + "*", PathConfig.API_VERIFICATION + "*").permitAll().anyRequest().authenticated().and();
        // 认证过滤器
        role.addFilterBefore(appAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}