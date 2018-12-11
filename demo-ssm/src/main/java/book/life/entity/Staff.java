package book.life.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.sql.Timestamp;

@Alias("Staff")
public class Staff implements Serializable {

    private Long sid;
    private String realName;
    private String mobile;
    private String email;
    private String password;
    private Long gid;
    private Timestamp createTime;
    private Timestamp lastLoginTime;
    private Integer isDelete;

    public Staff() {
    }

    // find
    public Staff(String realName, String mobile) {
        this.realName = realName;
        this.mobile = mobile;
    }

    // save
    public Staff(String realName, String mobile, String email, String password, Long gid, Timestamp createTime) {
        this.realName = realName;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
        this.gid = gid;
        this.createTime = createTime;
    }

    // findByMobile
    public Staff(String mobile) {
        this.mobile = mobile;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
