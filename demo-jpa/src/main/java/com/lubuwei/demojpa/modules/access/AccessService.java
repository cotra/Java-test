package com.lubuwei.demojpa.modules.access;

import com.lubuwei.demojpa.entity.User;
import com.lubuwei.demojpa.dao.UserDao;
import com.lubuwei.demojpa.modules.access.dto.Flag;
import com.lubuwei.demojpa.modules.access.dto.UserLogin;
import com.lubuwei.demojpa.utils.MD5Utils;
import com.lubuwei.demojpa.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessService {

    @Autowired
    private UserDao userDao;

    // 管理员查询条件
    private Example<User> registerExample(User user) {
        user.setIsDelete(0); // 逻辑存在的用户
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("mobile", ExampleMatcher.GenericPropertyMatchers.exact())
                .withIgnorePaths("password");

        return Example.of(user, matcher);
    }

    // 注册一个用户
    public Long register(User user) {
        // 查询
        List<User> list = userDao.findAll(registerExample(user));
        // 检查是否已存在同手机号的记录, 没有就添加
        if (list.size() == 0) {
            // 动态写入
            user.setPassword(MD5Utils.toMD5(user.getPassword()));
            user.setCreateTime(TimeUtils.letDateToSqlTimestamp());
            // 保存
            userDao.save(user);
            return user.getUid();
        }
        return Flag.MOBILE_EXISTS;
    }

    // 管理员查询条件
    private Example<User> loginExample(User user) {
        user.setIsDelete(0); // 逻辑存在的用户
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("mobile", ExampleMatcher.GenericPropertyMatchers.exact())
                .withIgnorePaths("password");

        return Example.of(user, matcher);
    }

    // 登录
    public UserLogin login(User user, String code) {
        UserLogin userLogin = new UserLogin();
        List<User> list = userDao.findAll(loginExample(user));

        int size = list.size();
        if (size > 1) {
            userLogin.setFlag(Flag.MOBILE_MORE_ONE);
        }
        if (size == 0) {
            userLogin.setFlag(Flag.MOBILE_NO);
        }
        if (size == 1) {
            User info = list.get(0);
            System.out.println(info);
        }
        return userLogin;
    }
}
