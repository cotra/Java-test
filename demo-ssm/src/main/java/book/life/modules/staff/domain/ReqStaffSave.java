package book.life.modules.staff.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * Created by Administrator on 2018/9/6.
 */
public class ReqStaffSave {
    @NotBlank(message = "用户名不能为空")
    private String realName;
    @NotBlank(message = "手机号不能为空")
    private String mobile;
    @NotBlank(message = "邮箱不能为空")
    @Email(message="请输入正确格式的邮箱")
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
