package com.lubuwei2.ssm.modules.user;

import com.lubuwei2.ssm.entity.User;
import com.lubuwei2.ssm.modules.user.domain.UserBasicResult;
import com.lubuwei2.ssm.modules.user.dto.Flag;
import com.lubuwei2.ssm.modules.user.dto.UserLogin;
import com.lubuwei2.ssm.modules.user.dto.UserRegister;
import com.lubuwei2.ssm.utils.MD5Utils;
import com.lubuwei2.ssm.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return dto;
    }

    public UserLogin login(User user) {
        UserLogin dto = new UserLogin();
        // 查询
        user.setPassword(MD5Utils.toMD5(user.getPassword()));
        List<UserBasicResult> list = userDao.findByMobileAndPassword(user);
        if(list.size() == 1) {
            dto.setFlag(Flag.OK);
            dto.setUser(list.get(0));
        }
        if(list.size() == 2) {
            dto.setFlag(Flag.USER_MORE_ONE);
        }
        if(list.size() == 0) {
            dto.setFlag(Flag.MOBILE_OR_PASSWORD_ERROR);
        }
        return dto;
    }
}
