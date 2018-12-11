package com.lubuwei.demojpa.modules.access;

import com.lubuwei.demojpa.api.Api;
import com.lubuwei.demojpa.api.ApiGenerator;
import com.lubuwei.demojpa.entity.User;
import com.lubuwei.demojpa.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessService {

    @Autowired
    private UserDao userDao;

    public Api<Long> adminLogin(User user) {

        ExampleMatcher matcher = ExampleMatcher.matching();

        Example<User> example = Example.of(user, matcher);

        List<User> list = userDao.findAll(example);
        System.out.println(list.size());
        // 检查是否已存在同手机号和邮箱的用户, 没有就添加
//        if (drugMapper.findByCDANandCDSC(drug).size() == 0) {
//            drug.setCreateTime(TimeUtils.dateToSqlTimestamp());
//            // 保存
//            drugMapper.save(drug);
//            return drug.getDid();
//        }
        return ApiGenerator.ok(1L);
    }
}
