package book.life.modules.staff;

import book.life.api.Api;
import book.life.api.ApiGenerator;
import book.life.config.ConstantConfig;
import book.life.domain.PageList;
import book.life.modules.staff.domain.ReqStaffFind;
import book.life.modules.staff.domain.ReqStaffSave;
import book.life.modules.staff.domain.ResStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ConstantConfig.API_PATH_V1 + "staff")
public class StaffController {

    @Autowired
    StaffLogic staffLogic;

    @PostMapping("/save")
    public Api<String> save(@RequestBody @Validated ReqStaffSave req) {
        return staffLogic.save(req);
    }

    @PostMapping("/find")
    public Api<PageList<ResStaff>> find(@RequestBody @Validated ReqStaffFind req) {
        return staffLogic.find(req);
    }

    @GetMapping("/demo")
    public Api<String> find() {
        return ApiGenerator.ok("test");
    }
}
