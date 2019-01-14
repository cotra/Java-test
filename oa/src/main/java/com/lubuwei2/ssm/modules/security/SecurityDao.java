package com.lubuwei2.ssm.modules.security;

import com.lubuwei2.ssm.entity.Account;
import com.lubuwei2.ssm.modules.security.dto.LoginResult;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SecurityDao {
    // 根据eid和密码更新
    Integer updateByEidAndPwd(Account account);

    // 根据username和密码更新
    Integer updateByUsernameAndPwd(Account account);

    // 登录成功后返回
    List<LoginResult> findAfterLoginByEid(Long eid);

    // 登录成功后返回
    List<LoginResult> findAfterLoginByUsername(String username);
}
