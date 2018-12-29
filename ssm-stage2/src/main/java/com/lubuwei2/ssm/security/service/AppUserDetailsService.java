package com.lubuwei2.ssm.security.service;

import com.lubuwei2.ssm.entity.User;
import com.lubuwei2.ssm.modules.security.SecurityDao;
import com.lubuwei2.ssm.modules.security.domain.LoginRes;
import com.lubuwei2.ssm.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class AppUserDetailsService implements UserDetailsService, Serializable {

    @Autowired
    SecurityDao securityDao;

    @Override
    public UserDetails loadUserByUsername(String mobile) throws UsernameNotFoundException {
        System.out.println("系统用户信息" + mobile);
        User user = new User();
        user.setMobile(mobile);
        List<LoginRes> list = securityDao.findByMobile(user);
        int size = list.size();
        if (size == 0 || size > 1) {
            throw new UsernameNotFoundException("记录" + mobile + "不存在");
        }
        LoginRes res = list.get(0);
        return new SecurityUser(res.getUid(), res.getMobile(), "{noop}" + "123456");
    }
}