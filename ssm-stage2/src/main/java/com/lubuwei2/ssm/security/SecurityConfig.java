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

//    @Autowired
//    private AppAuthenticationProvider provider;//自定义验证

    //请求拦截
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // 禁止csrf
        HttpSecurity security = httpSecurity.csrf().disable();
        // 异常处理
        HttpSecurity role = security.exceptionHandling().authenticationEntryPoint(new AppAuthenticationEntryPoint()).accessDeniedHandler(new AppAccessDeniedHandler()).and();               // 权限设置
        System.out.println(PathConfig.API_SECURITY);
        HttpSecurity and = role.authorizeRequests().antMatchers(PathConfig.API_SECURITY + "*", PathConfig.API_VERIFICATION + "*").permitAll()
                .antMatchers("/api/v1/order/**").authenticated().and();
        // 添加过滤器
        and.addFilter(new AppAuthenticationFilter(authenticationManager()));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("user").password(new BCryptPasswordEncoder().encode("123456")).roles("USER");
    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        //将验证过程交给自定义验证工具
//        auth.authenticationProvider(provider);
//    }
}