package book.life.entity;

import org.apache.ibatis.type.Alias;

import java.sql.Date;
import java.sql.Timestamp;

@Alias("Drug")
public class Drug {
    private Long did;
    private String CDAN;
    private String CDSC;
    private String drugName;
    private String company;
    private String norm;
    private Date approvalDate;
    private Timestamp createTime;
    private Integer isDelete;

    public Drug() {
    }

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }

    public String getCDAN() {
        return CDAN;
    }

    public void setCDAN(String CDAN) {
        this.CDAN = CDAN;
    }

    public String getCDSC() {
        return CDSC;
    }

    public void setCDSC(String CDSC) {
        this.CDSC = CDSC;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getNorm() {
        return norm;
    }

    public void setNorm(String norm) {
        this.norm = norm;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
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
