package com.lubuwei2.ssm.modules.security;

import com.lubuwei2.ssm.api.Api;
import com.lubuwei2.ssm.api.ApiGenerator;
import com.lubuwei2.ssm.api.PathConfig;
import com.lubuwei2.ssm.entity.User;
import com.lubuwei2.ssm.modules.security.domain.LoginReq;
import com.lubuwei2.ssm.modules.security.domain.LoginRes;
import com.lubuwei2.ssm.modules.security.domain.RegisterReq;
import com.lubuwei2.ssm.modules.security.domain.RegisterRes;
import com.lubuwei2.ssm.modules.security.dto.Flag;
import com.lubuwei2.ssm.modules.security.dto.Login;
import com.lubuwei2.ssm.modules.security.dto.Register;
import com.lubuwei2.ssm.security.jwt.JwtGenerator;
import com.lubuwei2.ssm.utils.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = PathConfig.API_SECURITY)
public class SecurityController {

    @Autowired
    SecurityService service;

    @Autowired
    JwtGenerator jwt;

    @PostMapping("register")
    public Api<RegisterRes> register(@RequestBody @Validated RegisterReq req, HttpSession session) {
        if (session.getAttribute("userReg") != null) {
            return ApiGenerator.fail("验证码错误");
        }
        User user = ListUtils.entityToModel(req, User.class);
        Register dto = service.register(user);
        if (dto.getFlag() == Flag.OK) {
            RegisterRes res = new RegisterRes(dto.getUid());
            return ApiGenerator.ok(res);
        }
        if (dto.getFlag() == Flag.USER_EXISTS) {
            return ApiGenerator.fail("用户已经存在");
        }
        // 默认
        return ApiGenerator.fail();
    }

    /**
     * 登录成功后返回用户信息和一个jwt
     * 缓存中存储
     * @param req
     * @return
     */
    @PostMapping("login")
    public Api<LoginRes> login(@RequestBody @Validated LoginReq req) {
        User user = ListUtils.entityToModel(req, User.class);
        Login dto = service.login(user);
        if (dto.getFlag() == Flag.OK) {
            LoginRes res = ListUtils.entityToModel(dto.getUser(), LoginRes.class);
            // 根据返回用户信息生成jwt
            res.setToken(jwt.create(res.getMobile(), res.getUid().toString()));
            return ApiGenerator.ok(res);
        }
        // 默认
        return ApiGenerator.fail();
    }
}
