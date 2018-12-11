package book.life.entity;

import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Alias("Group")
public class Group {

    private Long gid;
    private String groupName;
    private Timestamp createTime;
    private Integer isDelete;

    public Group() {
    }

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public Group(String groupName, Timestamp createTime) {
        this.groupName = groupName;
        this.createTime = createTime;
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
