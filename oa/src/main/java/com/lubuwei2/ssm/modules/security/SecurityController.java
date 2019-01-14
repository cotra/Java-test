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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RequestMapping(value = PathConfig.API_SECURITY)
public class SecurityController {

    @Value("${jwt.name}")
    private String tokenName;

    @Autowired
    SecurityService service;

    @Autowired
    JwtGenerator jwt;

    /**
     * 注册登录账户名不能为纯数字,不能有@等特殊字符,只能是字母或字母+数字
     */
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
     * 11位电话号码,账户,员工号登录
     * 登录成功后返回用户信息和一个jwt
     */
    @PostMapping("login")
    public Api<LoginRes> login(@RequestBody @Validated LoginReq req) {
        Login dto = service.checkAndLogin(req.getKey(), req.getPassword());
//        Account account = ListUtils.entityToModel(req, Account.class);
        if (dto.getFlag() == Flag.OK) {
            LoginRes res = ListUtils.entityToModel(null, LoginRes.class);
            // 根据返回用户信息生成jwt
            Date iat = new Date(); // 签发时间
            String token = jwt.create(res.getMobile(), iat);
            res.setToken(token);
            // 返回
            return ApiGenerator.ok(res);
        }
        // 默认
        return ApiGenerator.fail();
    }


}
