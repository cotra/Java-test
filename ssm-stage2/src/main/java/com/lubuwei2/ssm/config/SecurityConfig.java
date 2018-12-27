package com.lubuwei2.ssm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //请求拦截
    @Override
    protected void configure(HttpSecurity security) throws Exception {
        // 禁止csrf
        HttpSecurity security1 = security.csrf().disable();
        // 允许访问
        security1.authorizeRequests().antMatchers("/api/v1/user/security/*").permitAll()
                .antMatchers("/api/v1/order/**").denyAll();
    }

}
