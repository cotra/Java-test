package com.lubuwei2.ssm.modules.user;

import com.lubuwei2.ssm.entity.User;
import com.lubuwei2.ssm.modules.user.dto.UserLogin;
import com.lubuwei2.ssm.modules.user.dto.UserRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class UserService {
    @Autowired
    private UserDao userDao;

    public UserRegister register(User user) {
        UserRegister dto = new UserRegister();
        return dto;
    }

    public UserLogin login(User user) {
        UserLogin dto = new UserLogin();
        return dto;
    }
}


