package com.lubuwei.demojpa.modules.access;

import com.lubuwei.demojpa.api.Api;
import com.lubuwei.demojpa.api.ApiGenerator;
import com.lubuwei.demojpa.api.PathConfig;
import com.lubuwei.demojpa.modules.access.domain.UserRegister;
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
    public Api<String> register (@RequestBody @Validated UserRegister req) {
        Long register = accessService.register(AccessLogic.ToUser(req));
        return AccessLogic.registerApi(register);
    }
}
