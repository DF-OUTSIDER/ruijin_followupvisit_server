package application.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "DBlindEx", schema = "dbo")
public class DBlindExEntity {
    private int blindId;
    private String hospitalResearchId;
    private String userId;
    private Boolean isTrue;
    private Boolean isRevealed;
    private Timestamp inTime;
    private Timestamp outTime;
    private String outReason;
    private HospitalResearchEntity hospitalResearchByHospitalResearchId;
    private AppUserEntity appUserByUserId;
    private Collection<UserMedicineEntity> userMedicinesByBlindId;

    @Id
    @Column(name = "BlindId", nullable = false)
    public int getBlindId() {
        return blindId;
    }

    public void setBlindId(int blindId) {
        this.blindId = blindId;
    }

    @Basic
    @Column(name = "HospitalResearchId", nullable = false, length = 32)
    public String getHospitalResearchId() {
        return hospitalResearchId;
    }

    public void setHospitalResearchId(String hospitalResearchId) {
        this.hospitalResearchId = hospitalResearchId;
    }

    @Basic
    @Column(name = "UserId", nullable = false, length = 32)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "IsTrue", nullable = true)
    public Boolean getTrue() {
        return isTrue;
    }

    public void setTrue(Boolean aTrue) {
        isTrue = aTrue;
    }

    @Basic
    @Column(name = "IsRevealed", nullable = true)
    public Boolean getRevealed() {
        return isRevealed;
    }

    public void setRevealed(Boolean revealed) {
        isRevealed = revealed;
    }

    @Basic
    @Column(name = "InTime", nullable = true)
    public Timestamp getInTime() {
        return inTime;
    }

    public void setInTime(Timestamp inTime) {
        this.inTime = inTime;
    }

    @Basic
    @Column(name = "OutTime", nullable = true)
    public Timestamp getOutTime() {
        return outTime;
    }

    public void setOutTime(Timestamp outTime) {
        this.outTime = outTime;
    }

    @Basic
    @Column(name = "OutReason", nullable = true, length = 200)
    public String getOutReason() {
        return outReason;
    }

    public void setOutReason(String outReason) {
        this.outReason = outReason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DBlindExEntity that = (DBlindExEntity) o;
        return blindId == that.blindId &&
                Objects.equals(hospitalResearchId, that.hospitalResearchId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(isTrue, that.isTrue) &&
                Objects.equals(isRevealed, that.isRevealed) &&
                Objects.equals(inTime, that.inTime) &&
                Objects.equals(outTime, that.outTime) &&
                Objects.equals(outReason, that.outReason);
    }

    @Override
    public int hashCode() {

        return Objects.hash(blindId, hospitalResearchId, userId, isTrue, isRevealed, inTime, outTime, outReason);
    }

    @ManyToOne
    @JoinColumn(name = "HospitalResearchId", referencedColumnName = "HospitalResearchId", nullable = false, insertable = false, updatable = false)
    public HospitalResearchEntity getHospitalResearchByHospitalResearchId() {
        return hospitalResearchByHospitalResearchId;
    }

    public void setHospitalResearchByHospitalResearchId(HospitalResearchEntity hospitalResearchByHospitalResearchId) {
        this.hospitalResearchByHospitalResearchId = hospitalResearchByHospitalResearchId;
    }

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false, insertable = false, updatable = false)
    public AppUserEntity getAppUserByUserId() {
        return appUserByUserId;
    }

    public void setAppUserByUserId(AppUserEntity appUserByUserId) {
        this.appUserByUserId = appUserByUserId;
    }

    @OneToMany(mappedBy = "dBlindExByBlindId")
    public Collection<UserMedicineEntity> getUserMedicinesByBlindId() {
        return userMedicinesByBlindId;
    }

    public void setUserMedicinesByBlindId(Collection<UserMedicineEntity> userMedicinesByBlindId) {
        this.userMedicinesByBlindId = userMedicinesByBlindId;
    }
}
