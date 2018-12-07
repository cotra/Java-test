package com.lubuwei.demojpa.modules.user;

import com.lubuwei.demojpa.api.Api;
import com.lubuwei.demojpa.api.ApiGenerator;
import com.lubuwei.demojpa.modules.user.domain.UserSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("")
    public String index() {
        return "user service is running";
    }

    @GetMapping("save")
    public Api<Long> save() {
        UserSave userSave = new UserSave();
        Api<Long> api = userService.save(UserLogic.RequestToSave(userSave));
        return api;
    }
}
