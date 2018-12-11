package book.life.modules.drug;

import book.life.api.Api;
import book.life.api.ApiGenerator;
import book.life.api.Code;
import book.life.domain.PageList;
import book.life.entity.Drug;
import book.life.modules.drug.domain.ReqDrugFind;
import book.life.modules.drug.domain.ReqDrugSave;
import book.life.modules.drug.domain.ResDrug;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrugLogic {

    @Autowired
    DrugService drugService;

    private Drug RequestToSave(Object req) {
        Drug drug = new Drug();
        BeanUtils.copyProperties(req, drug);
        return drug;
    }

    public Api<String> save(ReqDrugSave req) {
        Drug drug = RequestToSave(req);
        Long result = drugService.save(drug);
        if (result == -1L) {
            return ApiGenerator.fail(Code.FAILURE);
        }
        return ApiGenerator.ok(result.toString());
    }

    public Api<PageList<ResDrug>> find(ReqDrugFind req) {
        Drug drug = RequestToSave(req);
        PageList<ResDrug> list = drugService.find(req.getPage(), req.getRow(), drug);
        return ApiGenerator.ok(list);
    }
}
