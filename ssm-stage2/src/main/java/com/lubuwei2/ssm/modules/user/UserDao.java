package com.lubuwei2.ssm.modules.user;

import com.lubuwei2.ssm.domain.BasicMapper;
import com.lubuwei2.ssm.domain.FindMapper;
import com.lubuwei2.ssm.entity.User;
import com.lubuwei2.ssm.modules.user.domain.UserBasicResult;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao extends BasicMapper<User>, FindMapper<User, UserBasicResult> {
}
