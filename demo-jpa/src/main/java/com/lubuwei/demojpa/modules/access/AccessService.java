package com.lubuwei.demojpa.modules.access;

import com.lubuwei.demojpa.entity.User;
import com.lubuwei.demojpa.dao.UserDao;
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
    private ExampleMatcher adminLimit() {
        return ExampleMatcher.matching()
                .withMatcher("mobile", ExampleMatcher.GenericPropertyMatchers.exact())
                .withIgnorePaths("email");
    }

    // 注册一个管理员
    public Long adminLogin(User user) {
        Example<User> example = Example.of(user, adminLimit());

        List<User> list = userDao.findAll(example);
        // 检查是否已存在同手机号的记录, 没有就添加
        if (list.size() == 0) {
            user.setCreateTime(TimeUtils.letDateToSqlTimestamp());
            // 保存
            userDao.save(user);
            return user.getUid();
        }
        return 0L;
    }
}
