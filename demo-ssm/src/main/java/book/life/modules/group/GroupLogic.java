package book.life.modules.group;

import book.life.api.Api;
import book.life.api.ApiGenerator;
import book.life.api.Code;
import book.life.domain.PageList;
import book.life.entity.Group;
import book.life.entity.Staff;
import book.life.modules.group.GroupService;
import book.life.modules.group.domain.ReqGroupFind;
import book.life.modules.group.domain.ReqGroupSave;
import book.life.modules.group.domain.ResGroup;
import book.life.modules.staff.domain.ReqStaffFind;
import book.life.modules.staff.domain.ReqStaffSave;
import book.life.modules.staff.domain.ResStaff;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class GroupLogic {

    @Autowired
    GroupService groupService;

    private Group RequestToSave(Object req) {
        Group group = new Group();
        BeanUtils.copyProperties(req, group);
        return group;
    }

    public Api<String> save(ReqGroupSave req) {
        Group group = RequestToSave(req);
        Long result = groupService.save(group);
        if (result == -1L) {
            return ApiGenerator.fail(Code.FAILURE_HAS_GROUP);
        }
        return ApiGenerator.ok(result.toString());
    }

    @Cacheable(value="group-list")
    public Api<PageList<ResGroup>> find(ReqGroupFind req) {
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        Group group = RequestToSave(req);
        PageList<ResGroup> list = groupService.getPageList(req.getPage(), req.getRow(), group);
        return ApiGenerator.ok(list);
    }
}
