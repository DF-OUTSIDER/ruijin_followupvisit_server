package application.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "CRF", schema = "dbo")
public class CrfEntity {
    private String visitCrfId;
    private String visitId;
    private int sheetTemplateId;
    private Integer crfInstanceId;
    private String crf;
    private Timestamp createTime;
    private String modifier;
    private String modifierId;
    private Timestamp modifyTime;
    private String visitCrfStatus;
    private VisitEntity visitByVisitId;
    private SheetTemplateEntity sheetTemplateBySheetTemplateId;

    @Id
    @Column(name = "VisitCRFId", nullable = false, length = 32)
    public String getVisitCrfId() {
        return visitCrfId;
    }

    public void setVisitCrfId(String visitCrfId) {
        this.visitCrfId = visitCrfId;
    }

    @Basic
    @Column(name = "VisitId", nullable = false, length = 32)
    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    @Basic
    @Column(name = "SheetTemplateId", nullable = false)
    public int getSheetTemplateId() {
        return sheetTemplateId;
    }

    public void setSheetTemplateId(int sheetTemplateId) {
        this.sheetTemplateId = sheetTemplateId;
    }

    @Basic
    @Column(name = "CRFInstanceId", nullable = true)
    public Integer getCrfInstanceId() {
        return crfInstanceId;
    }

    public void setCrfInstanceId(Integer crfInstanceId) {
        this.crfInstanceId = crfInstanceId;
    }

    @Basic
    @Column(name = "CRF", nullable = true, length = 2147483647)
    public String getCrf() {
        return crf;
    }

    public void setCrf(String crf) {
        this.crf = crf;
    }

    @Basic
    @Column(name = "CreateTime", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "Modifier", nullable = false, length = 32)
    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    @Basic
    @Column(name = "ModifierId", nullable = false, length = 50)
    public String getModifierId() {
        return modifierId;
    }

    public void setModifierId(String modifierId) {
        this.modifierId = modifierId;
    }

    @Basic
    @Column(name = "ModifyTime", nullable = false)
    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Basic
    @Column(name = "VisitCRFStatus", nullable = false, length = 20)
    public String getVisitCrfStatus() {
        return visitCrfStatus;
    }

    public void setVisitCrfStatus(String visitCrfStatus) {
        this.visitCrfStatus = visitCrfStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CrfEntity crfEntity = (CrfEntity) o;
        return sheetTemplateId == crfEntity.sheetTemplateId &&
                Objects.equals(visitCrfId, crfEntity.visitCrfId) &&
                Objects.equals(visitId, crfEntity.visitId) &&
                Objects.equals(crfInstanceId, crfEntity.crfInstanceId) &&
                Objects.equals(crf, crfEntity.crf) &&
                Objects.equals(createTime, crfEntity.createTime) &&
                Objects.equals(modifier, crfEntity.modifier) &&
                Objects.equals(modifierId, crfEntity.modifierId) &&
                Objects.equals(modifyTime, crfEntity.modifyTime) &&
                Objects.equals(visitCrfStatus, crfEntity.visitCrfStatus);
    }

    @Override
    public int hashCode() {

        return Objects.hash(visitCrfId, visitId, sheetTemplateId, crfInstanceId, crf, createTime, modifier, modifierId, modifyTime, visitCrfStatus);
    }

    @ManyToOne
    @JoinColumn(name = "VisitId", referencedColumnName = "VisitId", nullable = false, insertable = false, updatable = false)
    public VisitEntity getVisitByVisitId() {
        return visitByVisitId;
    }

    public void setVisitByVisitId(VisitEntity visitByVisitId) {
        this.visitByVisitId = visitByVisitId;
    }

    @ManyToOne
    @JoinColumn(name = "SheetTemplateId", referencedColumnName = "SheetTemplateId", nullable = false, insertable = false, updatable = false)
    public SheetTemplateEntity getSheetTemplateBySheetTemplateId() {
        return sheetTemplateBySheetTemplateId;
    }

    public void setSheetTemplateBySheetTemplateId(SheetTemplateEntity sheetTemplateBySheetTemplateId) {
        this.sheetTemplateBySheetTemplateId = sheetTemplateBySheetTemplateId;
    }
}
