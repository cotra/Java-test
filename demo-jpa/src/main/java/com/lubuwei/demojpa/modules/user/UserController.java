package com.lubuwei.demojpa.modules.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @RequestMapping("")
    public String index() {
        return "liapi server is running";
    }
}
