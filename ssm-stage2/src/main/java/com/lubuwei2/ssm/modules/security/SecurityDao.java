package com.lubuwei2.ssm.modules.security;

import com.lubuwei2.ssm.domain.BasicMapper;
import com.lubuwei2.ssm.domain.FindMapper;
import com.lubuwei2.ssm.entity.User;
import com.lubuwei2.ssm.modules.security.domain.LoginRes;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SecurityDao extends BasicMapper<User>, FindMapper<User, LoginRes> {
    // 根据手机查找
    List<LoginRes> findByMobile(User user);

    // 根据手机号好密码
    List<LoginRes> findByMobileAndPassword(User user);
}
