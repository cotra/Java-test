package com.lubuwei.demojpa.repository;

import com.lubuwei.demojpa.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<Order, Long> {
}
