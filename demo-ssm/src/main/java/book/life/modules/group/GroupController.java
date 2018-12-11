package book.life.modules.group;

import book.life.api.Api;
import book.life.api.ApiGenerator;
import book.life.config.ConstantConfig;
import book.life.domain.PageList;
import book.life.modules.group.domain.ReqGroupFind;
import book.life.modules.group.domain.ReqGroupSave;
import book.life.modules.group.domain.ResGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ConstantConfig.API_PATH_V1 + "group")
public class GroupController {

    @Autowired
    GroupLogic groupLogic;

    @PostMapping("/save")
    public Api<String> save(@RequestBody @Validated ReqGroupSave req) {
        return groupLogic.save(req);
    }

    @PostMapping("/find")
    public Api<PageList<ResGroup>> find(@RequestBody @Validated ReqGroupFind req) {
        return groupLogic.find(req);
    }

    @GetMapping("/demo")
    public Api<ResGroup> demo() {
        ResGroup resGroup = new ResGroup();
        resGroup.setGroupName("测试23123");
        return ApiGenerator.ok(resGroup);
    }
}
