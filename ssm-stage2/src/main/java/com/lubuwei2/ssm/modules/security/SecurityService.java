package com.lubuwei2.ssm.modules.security;

import com.lubuwei2.ssm.entity.User;
import com.lubuwei2.ssm.modules.security.dto.FindResult;
import com.lubuwei2.ssm.modules.security.dto.Flag;
import com.lubuwei2.ssm.modules.security.dto.Login;
import com.lubuwei2.ssm.modules.security.dto.Register;
import com.lubuwei2.ssm.utils.MD5Utils;
import com.lubuwei2.ssm.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class SecurityService {

    @Autowired
    private SecurityDao dao;

    // 注册
    public Register register(User user) {
        Register dto = new Register();
        // 检查是否已存在同手机号和邮箱的用户, 没有就添加
        if (dao.findByMobile(user).size() == 0) {
            // md5
            user.setPassword(MD5Utils.toMD5(user.getPassword()));
            user.setCreateTime(TimeUtils.letDateToSqlTimestamp());
            // 保存
            dao.save(user);
            dto.setFlag(Flag.OK);
            dto.setUid(user.getUid());
        } else {
            dto.setFlag(Flag.USER_EXISTS);
        }
        return dto;
    }

    // 登录,修改最后登录时间
    @CacheEvict(value = "securityInfo", allEntries=true)
    public Login login(User user) {
        // dto
        Login dto = new Login();
        // 实体操作
        user.setPassword(MD5Utils.toMD5(user.getPassword()));
        user.setLastLoginTime(TimeUtils.letDateToSqlTimestamp());
        // 记录操作
        Integer update = dao.updateByMobileAndPassword(user);
        if(update == 1) {
            List<FindResult> list = dao.findByMobileAndPassword(user);
            if(list.size() == 0) {
                dto.setFlag(Flag.MOBILE_OR_PASSWORD_ERROR);
            }
            if(list.size() == 2) {
                dto.setFlag(Flag.USER_MORE_ONE);
            }
            if(list.size() == 1) {
                dto.setFlag(Flag.OK);
                dto.setUser(list.get(0));
            }
        } else {
            dto.setFlag(Flag.MOBILE_OR_PASSWORD_ERROR);
        }
        return dto;
    }
}
