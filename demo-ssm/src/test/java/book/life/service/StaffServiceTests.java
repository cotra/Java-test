package book.life.service;

import book.life.domain.PageList;
import book.life.entity.Staff;
import book.life.modules.staff.StaffService;
import book.life.modules.staff.domain.ResStaff;
import book.life.utils.TimeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StaffServiceTests {

    @Autowired
    StaffService staffService;

    @Test
    public void saveTest() {
        Staff staff = new Staff("saveTest", "123121111", "sdf", "123222", 1L, TimeUtils.dateToSqlTimestamp());
        Long save = staffService.save(staff);
        System.out.println(save);
    }

    @Test
    public void findTest() {
        Staff staff = new Staff();
        PageList<ResStaff> list = staffService.find(1, 5, staff);
        System.out.println(list.getList().size());
    }

}
