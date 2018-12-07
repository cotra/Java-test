package com.lubuwei.demojpa.modules.user;

import com.lubuwei.demojpa.api.Api;
import com.lubuwei.demojpa.api.ApiGenerator;
import com.lubuwei.demojpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public Api<Long> save(User user) {
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
