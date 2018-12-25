package com.mbg;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class UserController {

    @GetMapping(value = "")
    public String find() {
        return "mvn mybatis-generator:generate -e";
    }
}
