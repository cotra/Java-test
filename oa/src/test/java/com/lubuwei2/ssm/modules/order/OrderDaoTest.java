package com.lubuwei2.ssm.modules.order;

import com.lubuwei2.ssm.entity.Order;
import com.lubuwei2.ssm.modules.order.domain.OrderBasicResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDaoTest {

    @Autowired
    OrderDao orderDao;

    @Test
    public void find() {
        Order order = new Order();
        List<OrderBasicResult> list = orderDao.find(order);
        assertNotNull(list);
    }
}