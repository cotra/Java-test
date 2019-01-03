package com.lubuwei2.ssm.modules.order;

import com.lubuwei2.ssm.domain.BasicMapper;
import com.lubuwei2.ssm.domain.FindMapper;
import com.lubuwei2.ssm.entity.Order;
import com.lubuwei2.ssm.modules.order.domain.OrderBasicResult;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderDao extends BasicMapper<Order>, FindMapper<Order, OrderBasicResult> {
}
