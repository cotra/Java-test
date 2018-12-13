package com.lubuwei.demojpa.modules.access;

import com.lubuwei.demojpa.entity.User;
import com.lubuwei.demojpa.dao.UserDao;
import com.lubuwei.demojpa.modules.access.domain.Flag;
import com.lubuwei.demojpa.modules.access.domain.UserLoginRes;
import com.lubuwei.demojpa.utils.MD5Utils;
import com.lubuwei.demojpa.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import sun.security.provider.MD4;
import sun.security.provider.MD5;

import java.util.List;

@Service
public class AccessService {

    @Autowired
    private UserDao userDao;

    // 管理员查询条件
    private Example<User> createExample(User user) {
        user.setIsDelete(0); // 没有删除的
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("mobile", ExampleMatcher.GenericPropertyMatchers.exact())
                .withIgnorePaths("password");

        return Example.of(user, matcher);
    }

    // 注册一个用户
    public Long register(User user) {
        // 查询
        List<User> list = userDao.findAll(createExample(user));
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

    // 登录
    public User login(User user) {

        return  user;
    }
}
