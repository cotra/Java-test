package com.lubuwei.demojpa.modules.access;


import com.lubuwei.demojpa.api.Api;
import com.lubuwei.demojpa.api.ApiGenerator;
import com.lubuwei.demojpa.constant.Flag;
import com.lubuwei.demojpa.entity.User;
import org.springframework.beans.BeanUtils;

class AccessLogic {
    static User ToUser(Object req) {
        User user = new User();
        BeanUtils.copyProperties(req, user);
        return user;
    }

    static Api<String> registerApi(Long flag) {
        if (flag == Flag.CREATE_FAIL) {
            return ApiGenerator.fail();
        }
        return ApiGenerator.ok(flag.toString());
    }
}
