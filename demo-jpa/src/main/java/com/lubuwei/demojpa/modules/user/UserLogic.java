package com.lubuwei.demojpa.modules.user;


import com.lubuwei.demojpa.entity.User;
import org.springframework.beans.BeanUtils;

class UserLogic {
    static User RequestToSave(Object req) {
        User user = new User();
        BeanUtils.copyProperties(req, user);
        return user;
    }
}
