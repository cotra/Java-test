package com.lubuwei.demojpa.modules.access;


import com.lubuwei.demojpa.api.Api;
import com.lubuwei.demojpa.api.ApiGenerator;
import com.lubuwei.demojpa.entity.User;
import com.lubuwei.demojpa.modules.access.dto.Flag;
import com.lubuwei.demojpa.modules.access.domain.UserLoginRes;
import com.lubuwei.demojpa.modules.access.dto.UserLogin;
import org.springframework.beans.BeanUtils;

class AccessLogic {
    static User ToUser(Object req) {
        User user = new User();
        BeanUtils.copyProperties(req, user);
        return user;
    }

    static Api<String> registerApi(Long flag) {
        if (flag == Flag.MOBILE_EXISTS) {
            return ApiGenerator.fail("手机号已经被注册");
        }
        return ApiGenerator.ok();
    }

    static Api<UserLoginRes> loginApi(UserLogin userLogin) {
        Long flag = userLogin.getFlag();
        if (flag == Flag.MOBILE_MORE_ONE) {
            return ApiGenerator.fail("用户查询失败");
        }
        if (flag == Flag.MOBILE_NO) {
            return ApiGenerator.fail("该用户不存在");
        }
        if (flag == Flag.OK) {

        }
        return ApiGenerator.ok(null);
    }
}
