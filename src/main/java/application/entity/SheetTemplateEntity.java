package application.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "SheetTemplate", schema = "dbo")
public class SheetTemplateEntity {
    private int sheetTemplateId;
    private String templateNum;
    private String researchId;
    private String templateName;
    private String templateDesc;
    private String template;
    private String templateParse;
    private boolean isValid;
    private String creator;
    private String creatorId;
    private Timestamp createTime;
    private String modifier;
    private String modifierId;
    private Timestamp lastModifyTime;
    private Integer dataCount;
    private String templateData;
    private Short fields;
    private Collection<CrfEntity> crfsBySheetTemplateId;
    private ResearchEntity researchByResearchId;
    private Collection<VisitModelSheetTemplateEntity> visitModelSheetTemplatesBySheetTemplateId;

    @Id
    @Column(name = "SheetTemplateId", nullable = false)
    public int getSheetTemplateId() {
        return sheetTemplateId;
    }

    public void setSheetTemplateId(int sheetTemplateId) {
        this.sheetTemplateId = sheetTemplateId;
    }

    @Basic
    @Column(name = "TemplateNum", nullable = false, length = 100)
    public String getTemplateNum() {
        return templateNum;
    }

    public void setTemplateNum(String templateNum) {
        this.templateNum = templateNum;
    }

    @Basic
    @Column(name = "ResearchId", nullable = false, length = 32)
    public String getResearchId() {
        return researchId;
    }

    public void setResearchId(String researchId) {
        this.researchId = researchId;
    }

    @Basic
    @Column(name = "TemplateName", nullable = true, length = 50)
    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    @Basic
    @Column(name = "TemplateDesc", nullable = true, length = 255)
    public String getTemplateDesc() {
        return templateDesc;
    }

    public void setTemplateDesc(String templateDesc) {
        this.templateDesc = templateDesc;
    }

    @Basic
    @Column(name = "Template", nullable = true, length = 2147483647)
    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    @Basic
    @Column(name = "TemplateParse", nullable = true, length = 2147483647)
    public String getTemplateParse() {
        return templateParse;
    }

    public void setTemplateParse(String templateParse) {
        this.templateParse = templateParse;
    }

    @Basic
    @Column(name = "IsValid", nullable = false)
    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    @Basic
    @Column(name = "Creator", nullable = false, length = 50)
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Basic
    @Column(name = "CreatorId", nullable = false, length = 32)
    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
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
    @Column(name = "Modifier", nullable = false, length = 50)
    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    @Basic
    @Column(name = "ModifierId", nullable = false, length = 32)
    public String getModifierId() {
        return modifierId;
    }

    public void setModifierId(String modifierId) {
        this.modifierId = modifierId;
    }

    @Basic
    @Column(name = "LastModifyTime", nullable = false)
    public Timestamp getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Timestamp lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    @Basic
    @Column(name = "DataCount", nullable = true)
    public Integer getDataCount() {
        return dataCount;
    }

    public void setDataCount(Integer dataCount) {
        this.dataCount = dataCount;
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
    @Column(name = "Fields", nullable = true)
    public Short getFields() {
        return fields;
    }

    public void setFields(Short fields) {
        this.fields = fields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SheetTemplateEntity that = (SheetTemplateEntity) o;
        return sheetTemplateId == that.sheetTemplateId &&
                isValid == that.isValid &&
                Objects.equals(templateNum, that.templateNum) &&
                Objects.equals(researchId, that.researchId) &&
                Objects.equals(templateName, that.templateName) &&
                Objects.equals(templateDesc, that.templateDesc) &&
                Objects.equals(template, that.template) &&
                Objects.equals(templateParse, that.templateParse) &&
                Objects.equals(creator, that.creator) &&
                Objects.equals(creatorId, that.creatorId) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(modifier, that.modifier) &&
                Objects.equals(modifierId, that.modifierId) &&
                Objects.equals(lastModifyTime, that.lastModifyTime) &&
                Objects.equals(dataCount, that.dataCount) &&
                Objects.equals(templateData, that.templateData) &&
                Objects.equals(fields, that.fields);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sheetTemplateId, templateNum, researchId, templateName, templateDesc, template, templateParse, isValid, creator, creatorId, createTime, modifier, modifierId, lastModifyTime, dataCount, templateData, fields);
    }

    @OneToMany(mappedBy = "sheetTemplateBySheetTemplateId")
    public Collection<CrfEntity> getCrfsBySheetTemplateId() {
        return crfsBySheetTemplateId;
    }

    public void setCrfsBySheetTemplateId(Collection<CrfEntity> crfsBySheetTemplateId) {
        this.crfsBySheetTemplateId = crfsBySheetTemplateId;
    }

    @ManyToOne
    @JoinColumn(name = "ResearchId", referencedColumnName = "ResearchId", nullable = false, insertable = false, updatable = false)
    public ResearchEntity getResearchByResearchId() {
        return researchByResearchId;
    }

    public void setResearchByResearchId(ResearchEntity researchByResearchId) {
        this.researchByResearchId = researchByResearchId;
    }

    @OneToMany(mappedBy = "sheetTemplateBySheetTemplateId")
    public Collection<VisitModelSheetTemplateEntity> getVisitModelSheetTemplatesBySheetTemplateId() {
        return visitModelSheetTemplatesBySheetTemplateId;
    }

    public void setVisitModelSheetTemplatesBySheetTemplateId(Collection<VisitModelSheetTemplateEntity> visitModelSheetTemplatesBySheetTemplateId) {
        this.visitModelSheetTemplatesBySheetTemplateId = visitModelSheetTemplatesBySheetTemplateId;
    }
}
