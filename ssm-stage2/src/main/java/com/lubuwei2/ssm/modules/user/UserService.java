package com.lubuwei2.ssm.modules.user;

import com.lubuwei2.ssm.entity.User;
import com.lubuwei2.ssm.modules.user.dto.Flag;
import com.lubuwei2.ssm.modules.user.dto.UserRegister;
import com.lubuwei2.ssm.utils.MD5Utils;
import com.lubuwei2.ssm.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class UserService {
    @Autowired
    private UserDao userDao;

    public UserRegister register(User user) {
        UserRegister dto = new UserRegister();
        // 检查是否已存在同手机号和邮箱的用户, 没有就添加
        if (userDao.findByMobile(user).size() == 0) {
            // md5
            user.setPassword(MD5Utils.toMD5(user.getPassword()));
            user.setCreateTime(TimeUtils.letDateToSqlTimestamp());
            // 保存
            userDao.save(user);
            dto.setFlag(Flag.OK);
            dto.setUid(user.getUid());
        } else {
            dto.setFlag(Flag.USER_EXISTS);
        }
        return  dto;
    }
}
