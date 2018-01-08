package application.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "SheetTemplateData", schema = "dbo")
public class SheetTemplateDataEntity {
    private int id;
    private int tempateId;
    private String templateName;
    private String memberId;
    private String medicalEventType;
    private String medicalDept;
    private String medicalEventId;
    private String templateData;
    private Timestamp createTime;
    private Timestamp modifyTime;
    private Integer preTemplateDataId;
    private Integer nexTemplateDataId;
    private Collection<SheetTemplateDataFieldEntity> sheetTemplateDataFieldsById;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TempateId", nullable = false)
    public int getTempateId() {
        return tempateId;
    }

    public void setTempateId(int tempateId) {
        this.tempateId = tempateId;
    }

    @Basic
    @Column(name = "TemplateName", nullable = false, length = 50)
    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    @Basic
    @Column(name = "MemberId", nullable = false, length = 50)
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    @Basic
    @Column(name = "MedicalEventType", nullable = true, length = 50)
    public String getMedicalEventType() {
        return medicalEventType;
    }

    public void setMedicalEventType(String medicalEventType) {
        this.medicalEventType = medicalEventType;
    }

    @Basic
    @Column(name = "MedicalDept", nullable = true, length = 50)
    public String getMedicalDept() {
        return medicalDept;
    }

    public void setMedicalDept(String medicalDept) {
        this.medicalDept = medicalDept;
    }

    @Basic
    @Column(name = "MedicalEventId", nullable = true, length = 50)
    public String getMedicalEventId() {
        return medicalEventId;
    }

    public void setMedicalEventId(String medicalEventId) {
        this.medicalEventId = medicalEventId;
    }

    @Basic
    @Column(name = "TemplateData", nullable = true, length = 2147483647)
    public String getTemplateData() {
        return templateData;
    }

    public void setTemplateData(String templateData) {
        this.templateData = templateData;
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
    @Column(name = "ModifyTime", nullable = false)
    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Basic
    @Column(name = "PreTemplateDataId", nullable = true)
    public Integer getPreTemplateDataId() {
        return preTemplateDataId;
    }

    public void setPreTemplateDataId(Integer preTemplateDataId) {
        this.preTemplateDataId = preTemplateDataId;
    }

    @Basic
    @Column(name = "NexTemplateDataId", nullable = true)
    public Integer getNexTemplateDataId() {
        return nexTemplateDataId;
    }

    public void setNexTemplateDataId(Integer nexTemplateDataId) {
        this.nexTemplateDataId = nexTemplateDataId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SheetTemplateDataEntity that = (SheetTemplateDataEntity) o;
        return id == that.id &&
                tempateId == that.tempateId &&
                Objects.equals(templateName, that.templateName) &&
                Objects.equals(memberId, that.memberId) &&
                Objects.equals(medicalEventType, that.medicalEventType) &&
                Objects.equals(medicalDept, that.medicalDept) &&
                Objects.equals(medicalEventId, that.medicalEventId) &&
                Objects.equals(templateData, that.templateData) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(modifyTime, that.modifyTime) &&
                Objects.equals(preTemplateDataId, that.preTemplateDataId) &&
                Objects.equals(nexTemplateDataId, that.nexTemplateDataId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, tempateId, templateName, memberId, medicalEventType, medicalDept, medicalEventId, templateData, createTime, modifyTime, preTemplateDataId, nexTemplateDataId);
    }

    @OneToMany(mappedBy = "sheetTemplateDataBySheetTemplateDataId")
    public Collection<SheetTemplateDataFieldEntity> getSheetTemplateDataFieldsById() {
        return sheetTemplateDataFieldsById;
    }

    public void setSheetTemplateDataFieldsById(Collection<SheetTemplateDataFieldEntity> sheetTemplateDataFieldsById) {
        this.sheetTemplateDataFieldsById = sheetTemplateDataFieldsById;
    }
}
