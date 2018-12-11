package book.life.domain;

import java.util.List;

public interface FindMapper<T, D> {
    D findByPK(Integer id); // 根据主键查找

    List<D> find(T domain);
}
