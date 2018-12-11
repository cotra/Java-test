package book.life.utils;

import book.life.domain.PageList;
import com.github.pagehelper.PageInfo;

/**
 * Created by Administrator on 2018/9/6.
 */
public class PageUtils {
    public static <T> PageList<T> create(PageInfo<T> info) {
        return new PageList<>(info.getPageNum(), info.getPageSize(), info.getTotal(), info.getList());
    }
}
