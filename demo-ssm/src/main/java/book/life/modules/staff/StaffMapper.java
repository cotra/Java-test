package book.life.modules.staff;

import book.life.domain.FindMapper;
import book.life.entity.Staff;
import book.life.domain.BasicMapper;
import book.life.modules.staff.domain.ResStaff;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StaffMapper extends BasicMapper<Staff>, FindMapper<Staff, ResStaff> {
    // 根据手机查找
    List<ResStaff> findByMobile(Staff staff);
}
