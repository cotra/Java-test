package book.life.modules.group;

import book.life.domain.BasicMapper;
import book.life.domain.FindMapper;
import book.life.entity.Group;
import book.life.modules.group.domain.ResGroup;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GroupMapper extends BasicMapper<Group>, FindMapper<Group, ResGroup> {
    // 根据组名查找
    List<ResGroup> findByGroupName(Group group);
}
