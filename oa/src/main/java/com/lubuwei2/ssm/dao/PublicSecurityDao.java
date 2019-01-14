package com.lubuwei2.ssm.dao;

import com.lubuwei2.ssm.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PublicSecurityDao {

    List<Account> findByUsername(String username);
}
