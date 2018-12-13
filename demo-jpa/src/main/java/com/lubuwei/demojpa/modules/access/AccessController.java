package com.lubuwei.demojpa.modules.access;

import com.lubuwei.demojpa.api.Api;
import com.lubuwei.demojpa.api.PathConfig;
import com.lubuwei.demojpa.modules.access.domain.UserLoginReq;
import com.lubuwei.demojpa.modules.access.domain.UserLoginRes;
import com.lubuwei.demojpa.modules.access.domain.UserRegisterReq;
import com.lubuwei.demojpa.modules.access.dto.UserLogin;
import com.lubuwei.demojpa.modules.access.dto.UserRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = PathConfig.API_ACCESS)
public class AccessController {

    @Autowired
    AccessService accessService;

    @PostMapping("register")
    public Api<UserRegisterReq> register (@RequestBody @Validated UserRegisterReq req) {
        UserRegister register = accessService.register(AccessLogic.ToUser(req));
        Api<UserRegisterReq> api = AccessLogic.registerApi(register);
        return api;
    }

    @PostMapping("login")
    public Api<UserLoginRes> login (@RequestBody @Validated UserLoginReq req) {
        UserLogin login = accessService.login(AccessLogic.ToUser(req), req.getCode());
        Api<UserLoginRes> api = AccessLogic.loginApi(login);
        return api;
    }
}
