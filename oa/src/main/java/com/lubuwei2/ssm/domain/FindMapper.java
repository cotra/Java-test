package com.lubuwei2.ssm.domain;

import java.util.List;

public interface FindMapper<T, D> {
    D findByPK(Long id); // 根据主键查找

    List<D> find(T domain);
}
