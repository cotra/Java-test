package com.lubuwei2.ssm.security;

import com.lubuwei2.ssm.api.PathConfig;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configurable
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //请求拦截
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // 禁止csrf
        HttpSecurity security = httpSecurity.csrf().disable();
        // 自定义异常处理
        HttpSecurity handler = security.exceptionHandling().authenticationEntryPoint(new AppAuthenticationEntryPoint()).accessDeniedHandler(new AppAccessDeniedHandler()).and();       // 权限设置
        // 规则
        HttpSecurity role = handler.authorizeRequests().antMatchers(PathConfig.API_SECURITY + "*", PathConfig.API_VERIFICATION + "*").permitAll().anyRequest().authenticated().and();
        // 添加过滤器
        role.addFilter(new AppAuthenticationFilter(authenticationManager()));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("user").password(new BCryptPasswordEncoder().encode("123456")).roles("USER");
    }
}