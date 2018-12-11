package book.life.mapper;

import book.life.entity.Staff;
import book.life.modules.staff.StaffMapper;
import book.life.modules.staff.domain.ResStaff;
import book.life.utils.TimeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StaffMapperTests {

    @Autowired
    StaffMapper staffMapper;

    @Test
    public void saveTest() {
        Staff staff = new Staff("test2", "123", "sdf", "123222", 1L, TimeUtils.dateToSqlTimestamp());
        staffMapper.save(staff);
        System.out.println(staff.getSid());
    }

    @Test
    public void findByMobileTest() {
        Staff staff = new Staff("123");
        List<ResStaff> list = staffMapper.findByMobile(staff);
        System.out.println(list.size());
    }

    @Test
    public void findTest() {
        Staff staff = new Staff("", "");
        List<ResStaff> list = staffMapper.find(staff);
        System.out.println(list.size());
    }

}
