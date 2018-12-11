package book.life.modules.group.domain;

import javax.validation.constraints.NotBlank;

/**
 * Created by Administrator on 2018/9/6.
 */
public class ReqGroupSave {
    @NotBlank(message = "组名称不能为空")
    private String groupName;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
