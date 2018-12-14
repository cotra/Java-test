package com.lubuwei.demojpa.modules.access;


import com.lubuwei.demojpa.api.Api;
import com.lubuwei.demojpa.api.ApiGenerator;
import com.lubuwei.demojpa.entity.User;
import com.lubuwei.demojpa.modules.access.domain.UserRegisterRes;
import com.lubuwei.demojpa.modules.access.dto.Flag;
import com.lubuwei.demojpa.modules.access.domain.UserLoginRes;
import com.lubuwei.demojpa.modules.access.dto.UserLogin;
import com.lubuwei.demojpa.modules.access.dto.UserRegister;
import org.springframework.beans.BeanUtils;

class AccessLogic {

    // 对象属性生成
    static User ToUser(Object req) {
        User user = new User();
        BeanUtils.copyProperties(req, user);
        return user;
    }

    // 注册api
    static Api<UserRegisterRes> registerApi(UserRegister dto) {
        Integer flag = dto.getFlag();
        // 失败返回
        if (flag == Flag.USER_EXISTS) {
            return ApiGenerator.fail("手机号已经被注册");
        }
        // 成功返回
        if (flag == Flag.OK) {
            UserRegisterRes res = new UserRegisterRes(dto.getUid());
            return ApiGenerator.ok(res);
        }
        return ApiGenerator.fail();
    }

    // 对象属性生成
    static UserLoginRes ToUserLoginRes(User user) {
        UserLoginRes res = new UserLoginRes();
        BeanUtils.copyProperties(user, res);
        return res;
    }

    // 登录api
    static Api<UserLoginRes> loginApi(UserLogin dto) {
        Integer flag = dto.getFlag();
        // 失败返回
        if (flag == Flag.USER_MORE_ONE) {
            return ApiGenerator.fail("用户查询失败");
        }
        if (flag == Flag.MOBILE_NO) {
            return ApiGenerator.fail("该用户并不存在");
        }
        if (flag == Flag.PASSWORD_ERROR) {
            return ApiGenerator.fail("密码错误");
        }
        // 成功返回
        if (flag == Flag.OK) {
            UserLoginRes res = ToUserLoginRes(dto.getUser());
            return ApiGenerator.ok(res);
        }
        return ApiGenerator.fail();
    }
}
