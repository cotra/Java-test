package book.life.modules;

import book.life.api.Api;
import book.life.api.ApiGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("")
    public Api<String> index() {
        return ApiGenerator.ok("life book api server is running");
    }
}
