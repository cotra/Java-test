package com.lubuwei2.ssm.modules.security;

import com.lubuwei2.ssm.domain.BasicMapper;
import com.lubuwei2.ssm.domain.FindMapper;
import com.lubuwei2.ssm.entity.User;
import com.lubuwei2.ssm.modules.security.dto.FindResult;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SecurityDao extends BasicMapper<User>, FindMapper<User, FindResult> {
    // 根据手机查找
    List<FindResult> findByMobile(User user);

    // 根据手机号和密码
    List<FindResult> findByMobileAndPassword(User user);


}
