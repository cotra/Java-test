package com.lubuwei2.ssm.security.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class AnyUserDetailsService implements UserDetailsService, Serializable {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("---1");
        // 参数分别是：用户名，密码，用户权限
        User user = new User("user", "123456", AuthorityUtils.commaSeparatedStringToAuthorityList("USER"));
        return user;
    }
}