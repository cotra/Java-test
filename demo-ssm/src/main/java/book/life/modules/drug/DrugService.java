package book.life.modules.drug;

import book.life.domain.PageList;
import book.life.entity.Drug;
import book.life.modules.drug.domain.ResDrug;
import book.life.utils.PageUtils;
import book.life.utils.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugService {

    @Autowired
    private DrugMapper drugMapper;

    public Long save(Drug drug) {
        // 检查是否已存在同手机号和邮箱的用户, 没有就添加
        if (drugMapper.findByCDANandCDSC(drug).size() == 0) {
            drug.setCreateTime(TimeUtils.dateToSqlTimestamp());
            // 保存
            drugMapper.save(drug);
            return drug.getDid();
        }
        return -1L;
    }

    public PageList<ResDrug> find(Integer pageNum, Integer pageSize, Drug drug) {
        PageHelper.startPage(pageNum, pageSize);
        // 无查询条件
        List<ResDrug> list = drugMapper.find(drug);
        PageInfo<ResDrug> pageInfo = new PageInfo<>(list);
        return PageUtils.create(pageInfo);
    }
}
