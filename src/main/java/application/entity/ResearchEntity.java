package application.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Research", schema = "dbo")
public class ResearchEntity {
    private String researchId;
    private String researchName;
    private String description;
    private Timestamp endDate;
    private Timestamp startDate;
    private String chief;
    private String creatorId;
    private String creator;
    private Timestamp createDate;
    private String chiedId;
    private boolean isBlind;
    private boolean isDoubleBlind;
    private boolean isDel;
    private int modValue;
    private int alertValue;
    private Collection<DblindExConditionEntity> dblindExConditionsByResearchId;
    private Collection<HospitalResearchEntity> hospitalResearchesByResearchId;
    private Collection<MedicineEntity> medicinesByResearchId;
    private Collection<SheetTemplateEntity> sheetTemplatesByResearchId;
    private Collection<UserResearchEntity> userResearchesByResearchId;
    private Collection<VisitModelEntity> visitModelsByResearchId;

    @Id
    @Column(name = "ResearchId", nullable = false, length = 32)
    public String getResearchId() {
        return researchId;
    }

    public void setResearchId(String researchId) {
        this.researchId = researchId;
    }

    @Basic
    @Column(name = "ResearchName", nullable = false, length = 50)
    public String getResearchName() {
        return researchName;
    }

    public void setResearchName(String researchName) {
        this.researchName = researchName;
    }

    @Basic
    @Column(name = "Description", nullable = true, length = 200)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "EndDate", nullable = true)
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "StartDate", nullable = true)
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "Chief", nullable = false, length = 50)
    public String getChief() {
        return chief;
    }

    public void setChief(String chief) {
        this.chief = chief;
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
    @Column(name = "Creator", nullable = false, length = 50)
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Basic
    @Column(name = "CreateDate", nullable = false)
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "ChiedId", nullable = false, length = 32)
    public String getChiedId() {
        return chiedId;
    }

    public void setChiedId(String chiedId) {
        this.chiedId = chiedId;
    }

    @Basic
    @Column(name = "IsBlind", nullable = false)
    public boolean isBlind() {
        return isBlind;
    }

    public void setBlind(boolean blind) {
        isBlind = blind;
    }

    @Basic
    @Column(name = "IsDoubleBlind", nullable = false)
    public boolean isDoubleBlind() {
        return isDoubleBlind;
    }

    public void setDoubleBlind(boolean doubleBlind) {
        isDoubleBlind = doubleBlind;
    }

    @Basic
    @Column(name = "IsDel", nullable = false)
    public boolean isDel() {
        return isDel;
    }

    public void setDel(boolean del) {
        isDel = del;
    }

    @Basic
    @Column(name = "ModValue", nullable = false)
    public int getModValue() {
        return modValue;
    }

    public void setModValue(int modValue) {
        this.modValue = modValue;
    }

    @Basic
    @Column(name = "AlertValue", nullable = false)
    public int getAlertValue() {
        return alertValue;
    }

    public void setAlertValue(int alertValue) {
        this.alertValue = alertValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResearchEntity that = (ResearchEntity) o;
        return isBlind == that.isBlind &&
                isDoubleBlind == that.isDoubleBlind &&
                isDel == that.isDel &&
                modValue == that.modValue &&
                alertValue == that.alertValue &&
                Objects.equals(researchId, that.researchId) &&
                Objects.equals(researchName, that.researchName) &&
                Objects.equals(description, that.description) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(chief, that.chief) &&
                Objects.equals(creatorId, that.creatorId) &&
                Objects.equals(creator, that.creator) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(chiedId, that.chiedId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(researchId, researchName, description, endDate, startDate, chief, creatorId, creator, createDate, chiedId, isBlind, isDoubleBlind, isDel, modValue, alertValue);
    }

    @OneToMany(mappedBy = "researchByResearchId")
    public Collection<DblindExConditionEntity> getDblindExConditionsByResearchId() {
        return dblindExConditionsByResearchId;
    }

    public void setDblindExConditionsByResearchId(Collection<DblindExConditionEntity> dblindExConditionsByResearchId) {
        this.dblindExConditionsByResearchId = dblindExConditionsByResearchId;
    }

    @OneToMany(mappedBy = "researchByResearchId")
    public Collection<HospitalResearchEntity> getHospitalResearchesByResearchId() {
        return hospitalResearchesByResearchId;
    }

    public void setHospitalResearchesByResearchId(Collection<HospitalResearchEntity> hospitalResearchesByResearchId) {
        this.hospitalResearchesByResearchId = hospitalResearchesByResearchId;
    }

    @OneToMany(mappedBy = "researchByResearchId")
    public Collection<MedicineEntity> getMedicinesByResearchId() {
        return medicinesByResearchId;
    }

    public void setMedicinesByResearchId(Collection<MedicineEntity> medicinesByResearchId) {
        this.medicinesByResearchId = medicinesByResearchId;
    }

    @OneToMany(mappedBy = "researchByResearchId")
    public Collection<SheetTemplateEntity> getSheetTemplatesByResearchId() {
        return sheetTemplatesByResearchId;
    }

    public void setSheetTemplatesByResearchId(Collection<SheetTemplateEntity> sheetTemplatesByResearchId) {
        this.sheetTemplatesByResearchId = sheetTemplatesByResearchId;
    }

    @OneToMany(mappedBy = "researchByResearchId")
    public Collection<UserResearchEntity> getUserResearchesByResearchId() {
        return userResearchesByResearchId;
    }

    public void setUserResearchesByResearchId(Collection<UserResearchEntity> userResearchesByResearchId) {
        this.userResearchesByResearchId = userResearchesByResearchId;
    }

    @OneToMany(mappedBy = "researchByResearchId")
    public Collection<VisitModelEntity> getVisitModelsByResearchId() {
        return visitModelsByResearchId;
    }

    public void setVisitModelsByResearchId(Collection<VisitModelEntity> visitModelsByResearchId) {
        this.visitModelsByResearchId = visitModelsByResearchId;
    }
}
