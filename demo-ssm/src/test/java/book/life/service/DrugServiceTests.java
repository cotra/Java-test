package book.life.service;

import book.life.domain.PageList;
import book.life.entity.Drug;
import book.life.modules.drug.DrugMapper;
import book.life.modules.drug.DrugService;
import book.life.modules.drug.domain.ResDrug;
import book.life.utils.PageUtils;
import book.life.utils.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DrugServiceTests {

    @Autowired
    private DrugService drugService;

    @Test
    public void findTest() {
        Drug drug = new Drug();
        PageList<ResDrug> list = drugService.find(1, 15, drug);
        loop(list.getList());
    }

    public static void loop(List<ResDrug> list) {
        System.out.println(list.toString());
        int j = list.size();
        for (int i = 0; i < j; i++) {

        }
    }
}
