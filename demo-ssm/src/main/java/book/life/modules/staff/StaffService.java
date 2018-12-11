package book.life.modules.staff;

import book.life.domain.PageList;
import book.life.entity.Staff;
import book.life.modules.staff.domain.ResStaff;
import book.life.utils.Common;
import book.life.utils.PageUtils;
import book.life.utils.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    @Autowired
    private StaffMapper staffMapper;

    public Long save(Staff staff) {
        // 检查是否已存在同手机号和邮箱的用户, 没有就添加
        if (staffMapper.findByMobile(staff).size() == 0) {
            String md5Pwd;
            if (staff.getPassword() == null) {
                md5Pwd = Common.toMD5(staff.getMobile());
            } else {
                md5Pwd = Common.toMD5(staff.getPassword());
            }
            staff.setPassword(md5Pwd);
            staff.setCreateTime(TimeUtils.dateToSqlTimestamp());
            // 保存
            staffMapper.save(staff);
            return staff.getSid();
        }
        return -1L;
    }

    public PageList<ResStaff> find(Integer pageNum, Integer pageSize, Staff staff) {
        PageHelper.startPage(pageNum, pageSize);
        // 模糊查询
        if (staff.getRealName() != null && staff.getRealName().length() != 0) {
            staff.setRealName("%" + staff.getRealName() +"%");
        }
        List<ResStaff> list = staffMapper.find(staff);
        PageInfo<ResStaff> pageInfo = new PageInfo<>(list);
        return PageUtils.create(pageInfo);
    }
}
