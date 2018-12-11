package book.life.modules.group;

import book.life.domain.PageList;
import book.life.entity.Group;
import book.life.modules.group.domain.ResGroup;
import book.life.utils.PageUtils;
import book.life.utils.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupMapper groupMapper;

    public Long save(Group group) {
        // 检查是否已存在同手机号和邮箱的用户, 没有就添加
        if (groupMapper.findByGroupName(group).size() == 0) {
            group.setCreateTime(TimeUtils.dateToSqlTimestamp());
            // 保存
            groupMapper.save(group);
            return group.getGid();
        }
        return -1L;
    }

    public PageList<ResGroup> getPageList(Integer pageNum, Integer pageSize, Group group) {
        PageHelper.startPage(pageNum, pageSize);
        // 无查询条件
        List<ResGroup> list = find(group);
        PageInfo<ResGroup> pageInfo = new PageInfo<>(list);
        return PageUtils.create(pageInfo);
    }

    public List<ResGroup> find(Group group) {
        return groupMapper.find(group);
    }
}
