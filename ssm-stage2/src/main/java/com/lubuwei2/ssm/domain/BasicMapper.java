package com.lubuwei2.ssm.domain;

import java.util.List;

public interface BasicMapper<T> {
    Integer save(T domain); // 单个保存

    Integer saveBatch(List list);

    Integer update(T domain);

    Integer updateBatch(List list);

    Integer delete(T domain);

    Integer deleteBatch(List list);

    Integer deleteByPK(Long id);

    Integer deleteAll();

    Long count();
}
