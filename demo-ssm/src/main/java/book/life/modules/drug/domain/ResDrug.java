package book.life.modules.drug.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResDrug implements Serializable {
    private Long did;
    private String CDAN;
    private String CDSC;
    private String drugName;
    private String company;
    private String norm;
    private Date approvalDate;
    private Timestamp createTime;

    public ResDrug(Long did, String CDAN, String CDSC, String drugName, String company, String norm, Date approvalDate, Timestamp createTime) {
        this.did = did;
        this.CDAN = CDAN;
        this.CDSC = CDSC;
        this.drugName = drugName;
        this.company = company;
        this.norm = norm;
        this.approvalDate = approvalDate;
        this.createTime = createTime;
    }
}
