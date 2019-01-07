package com.lubuwei2.ssm.utils.pagination;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by Administrator on 2018/9/6.
 */
public class PageUtils {
    public static <T> void setPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
    }

    public static <T> PageList<T> create(List<T> list) {
        PageInfo<T> info = new PageInfo<>(list);
        PageList<T> pageList = new PageList<>(info.getPageNum(), info.getPageSize(), info.getTotal(), info.getList());
        return pageList;
    }
}
