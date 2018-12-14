package com.lubuwei.demojpa.dao;

import com.lubuwei.demojpa.entity.Order;
import com.lubuwei.demojpa.utils.TimeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDaoTest {

    @Autowired
    OrderDao orderDao;

    @Test
    public void save() {
        Order order = new Order();
        order.setMobile("15012345678");
        order.setCreateTime(TimeUtils.letDateToSqlTimestamp());
        orderDao.save(order);
    }
}