package com.lubuwei2.ssm.modules.security;

import com.lubuwei2.ssm.dao.PublicEmployeesDao;
import com.lubuwei2.ssm.entity.Account;
import com.lubuwei2.ssm.entity.Employee;
import com.lubuwei2.ssm.entity.User;
import com.lubuwei2.ssm.modules.security.dto.Flag;
import com.lubuwei2.ssm.modules.security.dto.Login;
import com.lubuwei2.ssm.modules.security.dto.LoginResult;
import com.lubuwei2.ssm.modules.security.dto.Register;
import com.lubuwei2.ssm.utils.MD5Utils;
import com.lubuwei2.ssm.utils.RegexUtils;
import com.lubuwei2.ssm.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class SecurityService {

    @Autowired
    private SecurityDao dao;

    @Autowired
    private PublicEmployeesDao publicEmployeesDao;

    // 注册
    public Register register(User user) {
        Register dto = new Register();
        // 检查是否已存在同手机号和邮箱的用户, 没有就添加
        if (false) {
            // md5
            user.setPassword(MD5Utils.toMD5(user.getPassword()));
            user.setCreateTime(TimeUtils.letDateToSqlTimestamp());
            // 保存
//            dao.save(null);
            dto.setFlag(Flag.OK);
            dto.setUid(user.getUid());
        } else {
            dto.setFlag(Flag.USER_EXISTS);
        }
        return dto;
    }

    /**
     * 判断是手机号码or账户or员工号并登录
     */
    public Login checkAndLogin(String flag, String pwd) {
        // 手机或者员工号
        if(RegexUtils.checkDigit(flag)) {
            return loginByEid(flag, pwd);
        }
        // 账户
        return loginByUsername(flag, pwd);
    }

    /**
     * 可能是手机号码or账户
     */
    private Login loginByEid(String flag, String password) {
        Login dto = new Login();
        // 判断是否有用户
        List<Employee> list = publicEmployeesDao.findByFlag(flag);
        if (list.size() == 0) {
            dto.setFlag(Flag.ACCOUNT_OR_PASSWORD_ERROR);
            return dto;
        }
        if (list.size() > 1) {
            dto.setFlag(Flag.USER_MORE_ONE);
            return dto;
        }
        Long eid = list.get(0).getEid();
        // 修改登录时间
        Account account = new Account(eid, MD5Utils.toMD5(password), TimeUtils.letDateToSqlTimestamp());
        Integer update = dao.updateByEidAndPwd(account);
        if(update == 1) {
            List<LoginResult> login = dao.findAfterLoginByEid(eid);
            if(login.size() == 0) {
                dto.setFlag(Flag.ACCOUNT_OR_PASSWORD_ERROR);
                return dto;
            }
            if(login.size() == 2) {
                dto.setFlag(Flag.USER_MORE_ONE);
                return dto;
            }
            if(login.size() == 1) {
                dto.setFlag(Flag.OK);
                dto.setResult(login.get(0));
                return dto;
            }
        } else {
            dto.setFlag(Flag.ACCOUNT_OR_PASSWORD_ERROR);
            return dto;
        }
        return dto;
    }

    // 使用username登录
//    @CacheEvict(value = "securityInfo", allEntries=true)
    public Login loginByUsername(String flag, String password) {
        // dto
        Login dto = new Login();

        // 修改登录时间
        Account account = new Account(flag, MD5Utils.toMD5(password), TimeUtils.letDateToSqlTimestamp());
        Integer update = dao.updateByUsernameAndPwd(account);
        if(update == 1) {
            List<LoginResult> login = dao.findAfterLoginByUsername(flag);
            if(login.size() == 0) {
                dto.setFlag(Flag.ACCOUNT_OR_PASSWORD_ERROR);
                return dto;
            }
            if(login.size() == 2) {
                dto.setFlag(Flag.USER_MORE_ONE);
                return dto;
            }
            if(login.size() == 1) {
                dto.setFlag(Flag.OK);
                dto.setResult(login.get(0));
                return dto;
            }
        } else {
            dto.setFlag(Flag.ACCOUNT_OR_PASSWORD_ERROR);
            return dto;
        }
        return dto;
    }
}
