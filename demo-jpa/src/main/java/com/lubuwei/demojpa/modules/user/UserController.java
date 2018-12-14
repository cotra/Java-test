package com.lubuwei.demojpa.modules.user;

import com.lubuwei.demojpa.api.Api;
import com.lubuwei.demojpa.api.PathConfig;
import com.lubuwei.demojpa.entity.User;
import com.lubuwei.demojpa.modules.user.domain.UserLoginReq;
import com.lubuwei.demojpa.modules.user.domain.UserLoginRes;
import com.lubuwei.demojpa.modules.user.domain.UserRegisterReq;
import com.lubuwei.demojpa.modules.user.domain.UserRegisterRes;
import com.lubuwei.demojpa.modules.user.dto.UserLogin;
import com.lubuwei.demojpa.modules.user.dto.UserRegister;
import com.lubuwei.demojpa.utils.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = PathConfig.API_USER)
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("register")
    public Api<UserRegisterRes> register (@RequestBody @Validated UserRegisterReq req) {
        // 合并到实体对象
        User user = ListUtils.entityToModel(req, User.class);
        // 调用服务
        UserRegister register = userService.register(user, req.getCode());
        // 生成api
        Api<UserRegisterRes> api = UserLogic.registerApi(register);
        return api;
    }

    @PostMapping("login")
    public Api<UserLoginRes> login (@RequestBody @Validated UserLoginReq req) {
        // 合并到实体对象
        User user = ListUtils.entityToModel(req, User.class);
        // 调用服务
        UserLogin login = userService.login(user, req.getCode());
        // 生成api
        Api<UserLoginRes> api = UserLogic.loginApi(login);
        return api;
    }
}
