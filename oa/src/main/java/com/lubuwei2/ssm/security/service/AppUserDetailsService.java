package com.lubuwei2.ssm.security.service;

import com.lubuwei2.ssm.dao.PublicSecurityDao;
import com.lubuwei2.ssm.entity.Account;
import com.lubuwei2.ssm.modules.security.SecurityDao;
import com.lubuwei2.ssm.modules.security.domain.LoginRes;
import com.lubuwei2.ssm.security.entity.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * 每次验证读数据表太扯淡了,加个缓存
 */

@Service
public class AppUserDetailsService implements UserDetailsService, Serializable {

    @Autowired
    PublicSecurityDao dao;

    @Override
    @Cacheable(value = "securityInfo")
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Account> list = dao.findByUsername(username);
        int size = list.size();
        if (size == 0 || size > 1) {
            throw new UsernameNotFoundException("账户: " + username + "不存在");
        }
        Account account = list.get(0);
        // 用户名
        String name = account.getUsername();
        // 上次登录时间作为密码
        long time = account.getLastLoginTime().getTime();
        return new SecurityUser(account.getEid(), name, "{noop}" + time);
    }
}