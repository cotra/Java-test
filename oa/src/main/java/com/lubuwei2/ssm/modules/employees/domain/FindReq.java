package com.lubuwei2.ssm.modules.employees.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class FindReq {
    @NotNull(message = "缺少页码")
    private Integer page;
    @NotNull(message = "缺少条数")
    private Integer rows;
    @NotNull(message = "缺少参数 firstName")
    private String firstName;
    @NotNull(message = "缺少参数 lastName")
    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
