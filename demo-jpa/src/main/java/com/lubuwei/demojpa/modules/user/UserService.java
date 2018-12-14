package com.lubuwei.demojpa.modules.user;

import com.lubuwei.demojpa.entity.User;
import com.lubuwei.demojpa.dao.UserDao;
import com.lubuwei.demojpa.modules.user.dto.Flag;
import com.lubuwei.demojpa.modules.user.dto.UserLogin;
import com.lubuwei.demojpa.modules.user.dto.UserRegister;
import com.lubuwei.demojpa.utils.MD5Utils;
import com.lubuwei.demojpa.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    // 用户查询条件
    private Example<User> registerExample(User user) {
        user.setIsDelete(0); // 逻辑存在的用户
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("mobile", ExampleMatcher.GenericPropertyMatchers.exact())
                .withIgnorePaths("password");

        return Example.of(user, matcher);
    }

    // 注册一个用户
    UserRegister register(User user, String code) {
        UserRegister dto = new UserRegister();
        // 查询
        List<User> list = userDao.findAll(registerExample(user));
        // 检查是否已存在同手机号的记录, 没有就添加
        if (list.size() != 0) {
            dto.setFlag(Flag.USER_EXISTS);
            return dto;
        } else {
            // 动态写入
            user.setPassword(MD5Utils.toMD5(user.getPassword()));
            user.setCreateTime(TimeUtils.letDateToSqlTimestamp());
            // 保存
            userDao.save(user);
            dto.setUid(user.getUid());
            dto.setFlag(Flag.OK);
            return dto;
        }
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
    UserLogin login(User user, String code) {
        UserLogin dto = new UserLogin();
        List<User> list = userDao.findAll(loginExample(user));
        int size = list.size();
        if (size > 1) {
            dto.setFlag(Flag.USER_MORE_ONE);
            return dto;
        }
        if (size == 0) {
            dto.setFlag(Flag.MOBILE_NO);
            return dto;
        }
        if (size == 1) {
            User info = list.get(0);
            // 密码检查
            if (checkPasswordMD5(user.getPassword(), info.getPassword())) {
                dto.setUser(info);
                dto.setFlag(Flag.OK);
            } else {
                dto.setFlag(Flag.PASSWORD_ERROR);
                return dto;
            }
        }
        return dto;
    }

    private boolean checkPasswordMD5(String req, String record) {
        String md5 = MD5Utils.toMD5(req);
        return md5.equals(record);
    }
}
