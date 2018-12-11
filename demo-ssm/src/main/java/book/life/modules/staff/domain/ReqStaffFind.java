package book.life.modules.staff.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by Administrator on 2018/9/6.
 */
public class ReqStaffFind {
    @NotNull(message = "缺少用户名参数")
    private String realName;
    @NotNull(message = "缺少手机号参数")
    private String mobile;
    @NotNull(message = "缺少查询页码")
    private Integer page;
    @NotNull(message = "缺少每页条数")
    private Integer row;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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
}
