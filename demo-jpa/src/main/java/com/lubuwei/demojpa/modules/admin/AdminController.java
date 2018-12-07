package com.lubuwei.demojpa.modules.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "admin")
public class AdminController {

    @RequestMapping("")
    public String index() {
        String nickname = "nickname";
        return "liapi server is running";
    }
}
