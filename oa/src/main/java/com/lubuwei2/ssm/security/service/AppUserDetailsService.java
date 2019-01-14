package com.lubuwei2.ssm.security.service;

import com.lubuwei2.ssm.entity.User;
import com.lubuwei2.ssm.modules.security.SecurityDao;
import com.lubuwei2.ssm.modules.security.domain.LoginRes;
import com.lubuwei2.ssm.modules.security.dto.FindResult;
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
    SecurityDao securityDao;

    @Override
    @Cacheable(value = "securityInfo")
    public UserDetails loadUserByUsername(String mobile) throws UsernameNotFoundException {
        List<FindResult> list = null;
        int size = list.size();
        if (size == 0 || size > 1) {
            throw new UsernameNotFoundException("记录" + mobile + "不存在");
        }
        FindResult res = list.get(0);
        // 电话号码作为用户名
        String name = res.getMobile();
        // 上次登录时间作为密码
        long time = res.getLastLoginTime().getTime();
        return new SecurityUser(res.getUid(), name, "{noop}" + time);
    }
}