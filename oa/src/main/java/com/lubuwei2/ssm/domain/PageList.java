package com.lubuwei2.ssm.domain;

import java.io.Serializable;
import java.util.List;

public class PageList<T> implements Serializable {
    // 当前页
    private Integer page;
    // 每页条数
    private Integer row;
    // 总条数
    private Long total;
    // 分页结果
    private List<T> list;

    public PageList(Integer currentPage, Integer pageSize, Long totalNum, List<T> list) {
        this.page = currentPage;
        this.row = pageSize;
        this.total = totalNum;
        this.list = list;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
