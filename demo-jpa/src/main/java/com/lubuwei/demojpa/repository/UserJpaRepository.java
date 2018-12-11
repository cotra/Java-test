package com.lubuwei.demojpa.repository;

import com.lubuwei.demojpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {
}
