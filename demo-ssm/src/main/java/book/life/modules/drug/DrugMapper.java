package book.life.modules.drug;

import book.life.domain.BasicMapper;
import book.life.domain.FindMapper;
import book.life.entity.Drug;
import book.life.modules.drug.domain.ResDrug;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DrugMapper extends BasicMapper<Drug>, FindMapper<Drug, ResDrug> {
    // 根据组名查找
    List<ResDrug> findByCDANandCDSC(Drug drug);
}
