package com.lubuwei2.ssm.modules.user;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.lubuwei2.ssm.api.Api;
import com.lubuwei2.ssm.api.ApiGenerator;
import com.lubuwei2.ssm.api.PathConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;

@RestController
@RequestMapping(value = PathConfig.API_USER)
public class UserController {

    @Autowired
    DefaultKaptcha defaultKaptcha;

    @PostMapping("register")
    public Api<String> register () {
        String createText = defaultKaptcha.createText();
        BufferedImage image = defaultKaptcha.createImage(createText);
        return ApiGenerator.ok(createText);
    }
}
