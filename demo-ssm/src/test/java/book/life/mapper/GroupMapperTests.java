package book.life.mapper;

import book.life.entity.Group;
import book.life.entity.Staff;
import book.life.modules.group.GroupMapper;
import book.life.modules.group.domain.ResGroup;
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
public class GroupMapperTests {

    @Autowired
    GroupMapper groupMapper;

    @Test
    public void findByGroupNameTest() {
        Group group = new Group("超级管理员");
        List<ResGroup> list = groupMapper.findByGroupName(group);
        System.out.println(list.size());
    }

    @Test
    public void saveTest() {
        Group group = new Group("管理员", TimeUtils.dateToSqlTimestamp());
        groupMapper.save(group);
        System.out.println(group.getGid());
    }

    @Test
    public void findTest() {
        Group group = new Group();
        List<ResGroup> list = groupMapper.find(group);
        System.out.println(list.size());
    }

}
