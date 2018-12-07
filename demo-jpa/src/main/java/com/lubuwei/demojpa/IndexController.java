package com.lubuwei.demojpa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("")
    public String index() {
        return "api service is running";
    }

    @RequestMapping("/")
    public String main() {
        return "api service is running";
    }
}
