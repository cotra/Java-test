package com.lubuwei.demojpa.modules.access;

import com.lubuwei.demojpa.api.Api;
import com.lubuwei.demojpa.api.ApiGenerator;
import com.lubuwei.demojpa.api.PathConfig;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = PathConfig.API_ACCESS)
public class AccessController {

    @PostMapping("admin/login")
    public Api<String> adminLogin () {
        return ApiGenerator.ok("管理员注册");
    }

    @PostMapping("user/login")
    public Api<String> userLogin () {
        return ApiGenerator.ok("用户注册");
    }
}
