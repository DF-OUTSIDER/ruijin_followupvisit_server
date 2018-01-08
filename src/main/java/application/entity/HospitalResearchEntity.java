package application.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "HospitalResearch", schema = "dbo")
public class HospitalResearchEntity {
    private String hospitalResearchId;
    private String hospitalId;
    private String researchId;
    private boolean isLeader;
    private Collection<DBlindExEntity> dBlindicesByHospitalResearchId;
    private Collection<DataSetEntity> dataSetsByHospitalResearchId;
    private Collection<GroupEntity> groupsByHospitalResearchId;
    private HospitalEntity hospitalByHospitalId;
    private ResearchEntity researchByResearchId;
    private Collection<MedicineBarcodeSeedEntity> medicineBarcodeSeedsByHospitalResearchId;
    private Collection<MedicineHandOutEntity> medicineHandOutsByHospitalResearchId;
    private Collection<UserDblindConditionAnswerEntity> userDblindConditionAnswersByHospitalResearchId;
    private Collection<VisitEntity> visitsByHospitalResearchId;

    @Id
    @Column(name = "HospitalResearchId", nullable = false, length = 32)
    public String getHospitalResearchId() {
        return hospitalResearchId;
    }

    public void setHospitalResearchId(String hospitalResearchId) {
        this.hospitalResearchId = hospitalResearchId;
    }

    @Basic
    @Column(name = "HospitalId", nullable = false, length = 32)
    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
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
    @Column(name = "IsLeader", nullable = false)
    public boolean isLeader() {
        return isLeader;
    }

    public void setLeader(boolean leader) {
        isLeader = leader;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HospitalResearchEntity that = (HospitalResearchEntity) o;
        return isLeader == that.isLeader &&
                Objects.equals(hospitalResearchId, that.hospitalResearchId) &&
                Objects.equals(hospitalId, that.hospitalId) &&
                Objects.equals(researchId, that.researchId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(hospitalResearchId, hospitalId, researchId, isLeader);
    }

    @OneToMany(mappedBy = "hospitalResearchByHospitalResearchId")
    public Collection<DBlindExEntity> getdBlindicesByHospitalResearchId() {
        return dBlindicesByHospitalResearchId;
    }

    public void setdBlindicesByHospitalResearchId(Collection<DBlindExEntity> dBlindicesByHospitalResearchId) {
        this.dBlindicesByHospitalResearchId = dBlindicesByHospitalResearchId;
    }

    @OneToMany(mappedBy = "hospitalResearchByHospitalResearchId")
    public Collection<DataSetEntity> getDataSetsByHospitalResearchId() {
        return dataSetsByHospitalResearchId;
    }

    public void setDataSetsByHospitalResearchId(Collection<DataSetEntity> dataSetsByHospitalResearchId) {
        this.dataSetsByHospitalResearchId = dataSetsByHospitalResearchId;
    }

    @OneToMany(mappedBy = "hospitalResearchByHospitalResearchId")
    public Collection<GroupEntity> getGroupsByHospitalResearchId() {
        return groupsByHospitalResearchId;
    }

    public void setGroupsByHospitalResearchId(Collection<GroupEntity> groupsByHospitalResearchId) {
        this.groupsByHospitalResearchId = groupsByHospitalResearchId;
    }

    @ManyToOne
    @JoinColumn(name = "HospitalId", referencedColumnName = "HospitalId", nullable = false, insertable = false, updatable = false)
    public HospitalEntity getHospitalByHospitalId() {
        return hospitalByHospitalId;
    }

    public void setHospitalByHospitalId(HospitalEntity hospitalByHospitalId) {
        this.hospitalByHospitalId = hospitalByHospitalId;
    }

    @ManyToOne
    @JoinColumn(name = "ResearchId", referencedColumnName = "ResearchId", nullable = false, insertable = false, updatable = false)
    public ResearchEntity getResearchByResearchId() {
        return researchByResearchId;
    }

    public void setResearchByResearchId(ResearchEntity researchByResearchId) {
        this.researchByResearchId = researchByResearchId;
    }

    @OneToMany(mappedBy = "hospitalResearchByHospitalResearchId")
    public Collection<MedicineBarcodeSeedEntity> getMedicineBarcodeSeedsByHospitalResearchId() {
        return medicineBarcodeSeedsByHospitalResearchId;
    }

    public void setMedicineBarcodeSeedsByHospitalResearchId(Collection<MedicineBarcodeSeedEntity> medicineBarcodeSeedsByHospitalResearchId) {
        this.medicineBarcodeSeedsByHospitalResearchId = medicineBarcodeSeedsByHospitalResearchId;
    }

    @OneToMany(mappedBy = "hospitalResearchByHospitalResearchId")
    public Collection<MedicineHandOutEntity> getMedicineHandOutsByHospitalResearchId() {
        return medicineHandOutsByHospitalResearchId;
    }

    public void setMedicineHandOutsByHospitalResearchId(Collection<MedicineHandOutEntity> medicineHandOutsByHospitalResearchId) {
        this.medicineHandOutsByHospitalResearchId = medicineHandOutsByHospitalResearchId;
    }

    @OneToMany(mappedBy = "hospitalResearchByHospitalResearchId")
    public Collection<UserDblindConditionAnswerEntity> getUserDblindConditionAnswersByHospitalResearchId() {
        return userDblindConditionAnswersByHospitalResearchId;
    }

    public void setUserDblindConditionAnswersByHospitalResearchId(Collection<UserDblindConditionAnswerEntity> userDblindConditionAnswersByHospitalResearchId) {
        this.userDblindConditionAnswersByHospitalResearchId = userDblindConditionAnswersByHospitalResearchId;
    }

    @OneToMany(mappedBy = "hospitalResearchByHdId")
    public Collection<VisitEntity> getVisitsByHospitalResearchId() {
        return visitsByHospitalResearchId;
    }

    public void setVisitsByHospitalResearchId(Collection<VisitEntity> visitsByHospitalResearchId) {
        this.visitsByHospitalResearchId = visitsByHospitalResearchId;
    }
}
