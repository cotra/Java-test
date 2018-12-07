package com.lubuwei.demojpa.repository;

import com.lubuwei.demojpa.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
