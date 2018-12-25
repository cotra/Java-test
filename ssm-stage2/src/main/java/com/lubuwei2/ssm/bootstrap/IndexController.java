package com.lubuwei2.ssm.bootstrap;

import com.lubuwei2.ssm.api.Api;
import com.lubuwei2.ssm.api.ApiGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/")
    public Api<String> index() {
        return ApiGenerator.ok("api service is running.");
    }
}
