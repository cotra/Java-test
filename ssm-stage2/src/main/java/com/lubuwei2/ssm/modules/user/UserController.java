package com.lubuwei2.ssm.modules.user;

import com.lubuwei2.ssm.api.Api;
import com.lubuwei2.ssm.api.ApiGenerator;
import com.lubuwei2.ssm.api.PathConfig;
import com.lubuwei2.ssm.entity.User;
import com.lubuwei2.ssm.modules.user.domain.UserLoginReq;
import com.lubuwei2.ssm.modules.user.domain.UserLoginRes;
import com.lubuwei2.ssm.modules.user.domain.UserRegisterReq;
import com.lubuwei2.ssm.modules.user.domain.UserRegisterRes;
import com.lubuwei2.ssm.modules.user.dto.Flag;
import com.lubuwei2.ssm.modules.user.dto.UserLogin;
import com.lubuwei2.ssm.modules.user.dto.UserRegister;
import com.lubuwei2.ssm.utils.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = PathConfig.API_USER)
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("security/register")
    public Api<UserRegisterRes> register(@RequestBody @Validated UserRegisterReq req, HttpSession session) {
        if (session.getAttribute("userReg") != null) {
            return ApiGenerator.fail("验证码错误");
        }
        User user = ListUtils.entityToModel(req, User.class);
        UserRegister dto = userService.register(user);
        if (dto.getFlag() == Flag.OK) {
            UserRegisterRes res = new UserRegisterRes(dto.getUid());
            return ApiGenerator.ok(res);
        }
        if (dto.getFlag() == Flag.USER_EXISTS) {
            return ApiGenerator.fail("用户已经存在");
        }
        // 默认
        return ApiGenerator.fail();
    }

    @PostMapping("security/login")
    public Api<UserLoginRes> login(@RequestBody @Validated UserLoginReq req, HttpSession session) {
        User user = ListUtils.entityToModel(req, User.class);
        UserLogin dto = userService.login(user);
        if (dto.getFlag() == Flag.OK) {
            UserLoginRes res = ListUtils.entityToModel(dto.getUser(), UserLoginRes.class);
            return ApiGenerator.ok(res);
        }
        // 默认
        return ApiGenerator.fail();
    }
}
