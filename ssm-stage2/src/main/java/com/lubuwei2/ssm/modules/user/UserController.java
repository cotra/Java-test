package com.lubuwei2.ssm.modules.user;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.lubuwei2.ssm.api.Api;
import com.lubuwei2.ssm.api.ApiGenerator;
import com.lubuwei2.ssm.api.PathConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = PathConfig.API_USER)
public class UserController {

    @Autowired
    DefaultKaptcha defaultKaptcha;

    @PostMapping("register")
    public Api<String> register(HttpSession session) {
        System.out.println(session.getAttribute("login"));
        // 验证码可能为空
        return ApiGenerator.ok();
    }
}
