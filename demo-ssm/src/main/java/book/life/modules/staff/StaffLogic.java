package book.life.modules.staff;
import book.life.api.Api;
import book.life.api.ApiGenerator;
import book.life.api.Code;
import book.life.domain.PageList;
import book.life.modules.staff.domain.ReqStaffFind;
import book.life.modules.staff.domain.ReqStaffSave;
import book.life.entity.Staff;
import book.life.modules.staff.domain.ResStaff;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffLogic {

    @Autowired
    StaffService staffService;

    private Staff RequestToSave(Object req) {
        Staff staff = new Staff();
        BeanUtils.copyProperties(req, staff);
        return staff;
    }

    public Api<String> save(ReqStaffSave req) {
        Staff staff = RequestToSave(req);
        Long result = staffService.save(staff);
        if (result == -1L) {
            return ApiGenerator.fail(Code.FAILURE_HAS_STAFF);
        }
        return ApiGenerator.ok(result.toString());
    }

    public Api<PageList<ResStaff>> find(ReqStaffFind req) {
        Staff staff = RequestToSave(req);
        PageList<ResStaff> list = staffService.find(req.getPage(), req.getRow(), staff);
        return ApiGenerator.ok(list);
    }
}
