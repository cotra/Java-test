package com.lubuwei.demojpa.modules.access;


import com.lubuwei.demojpa.api.Api;
import com.lubuwei.demojpa.api.ApiGenerator;
import com.lubuwei.demojpa.entity.User;
import com.lubuwei.demojpa.modules.access.domain.Flag;
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
}
