package book.life.modules.drug;

import book.life.api.Api;
import book.life.api.ApiGenerator;
import book.life.config.ConstantConfig;
import book.life.domain.PageList;
import book.life.modules.drug.domain.ReqDrugFind;
import book.life.modules.drug.domain.ReqDrugSave;
import book.life.modules.drug.domain.ResDrug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ConstantConfig.API_PATH_V1 + "drug")
public class DrugController {

    @Autowired
    DrugLogic drugLogic;

    @RequestMapping("")
    public Api<String> index() {
        return ApiGenerator.ok("/api/v1/drug is running");
    }

    @PostMapping("/save")
    public Api<String> save(@RequestBody @Validated ReqDrugSave req) {
        return drugLogic.save(req);
    }

    @PostMapping("/find")
    public Api<PageList<ResDrug>> find(@RequestBody @Validated ReqDrugFind req) {
        return drugLogic.find(req);
    }
}
