package book.life.mapper;

import book.life.entity.Drug;
import book.life.entity.Group;
import book.life.modules.drug.DrugMapper;
import book.life.modules.drug.domain.ResDrug;
import book.life.modules.group.domain.ResGroup;
import book.life.utils.TimeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DrugMapperTests {

    @Autowired
    DrugMapper drugMapper;

    @Test
    public void findTest() {
        Drug drug = new Drug();
        List<ResDrug> list = drugMapper.find(drug);
        System.out.println();
    }
}
