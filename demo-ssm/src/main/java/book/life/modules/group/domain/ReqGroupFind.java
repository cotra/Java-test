package book.life.modules.group.domain;

import javax.validation.constraints.NotNull;

/**
 * Created by Administrator on 2018/9/6.
 */
public class ReqGroupFind {
    @NotNull(message = "缺少查询页码")
    private Integer page;
    @NotNull(message = "缺少每页条数")
    private Integer row;

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
}
