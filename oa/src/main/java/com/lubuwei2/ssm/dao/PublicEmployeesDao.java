package com.lubuwei2.ssm.dao;

import com.lubuwei2.ssm.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PublicEmployeesDao {

    /**
     * 根据key查找,key可能是电话号码或者员工号,返回eid
     */
    List<Employee> findByFlag(String flag);
}
