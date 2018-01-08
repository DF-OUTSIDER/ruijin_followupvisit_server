package application.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "UserDblindConditionAnswer", schema = "dbo")
public class UserDblindConditionAnswerEntity {
    private int answerId;
    private String userId;
    private String hospitalResearchId;
    private int conditionDetailId;
    private Timestamp answerDatetime;
    private AppUserEntity appUserByUserId;
    private HospitalResearchEntity hospitalResearchByHospitalResearchId;
    private DblindExConditionDetailEntity dblindExConditionDetailByConditionDetailId;

    @Id
    @Column(name = "AnswerId", nullable = false)
    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
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
    @Column(name = "HospitalResearchId", nullable = false, length = 32)
    public String getHospitalResearchId() {
        return hospitalResearchId;
    }

    public void setHospitalResearchId(String hospitalResearchId) {
        this.hospitalResearchId = hospitalResearchId;
    }

    @Basic
    @Column(name = "ConditionDetailId", nullable = false)
    public int getConditionDetailId() {
        return conditionDetailId;
    }

    public void setConditionDetailId(int conditionDetailId) {
        this.conditionDetailId = conditionDetailId;
    }

    @Basic
    @Column(name = "AnswerDatetime", nullable = false)
    public Timestamp getAnswerDatetime() {
        return answerDatetime;
    }

    public void setAnswerDatetime(Timestamp answerDatetime) {
        this.answerDatetime = answerDatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDblindConditionAnswerEntity that = (UserDblindConditionAnswerEntity) o;
        return answerId == that.answerId &&
                conditionDetailId == that.conditionDetailId &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(hospitalResearchId, that.hospitalResearchId) &&
                Objects.equals(answerDatetime, that.answerDatetime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(answerId, userId, hospitalResearchId, conditionDetailId, answerDatetime);
    }

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false, insertable = false, updatable = false)
    public AppUserEntity getAppUserByUserId() {
        return appUserByUserId;
    }

    public void setAppUserByUserId(AppUserEntity appUserByUserId) {
        this.appUserByUserId = appUserByUserId;
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
    @JoinColumn(name = "ConditionDetailId", referencedColumnName = "ConditionDetailId", nullable = false, insertable = false, updatable = false)
    public DblindExConditionDetailEntity getDblindExConditionDetailByConditionDetailId() {
        return dblindExConditionDetailByConditionDetailId;
    }

    public void setDblindExConditionDetailByConditionDetailId(DblindExConditionDetailEntity dblindExConditionDetailByConditionDetailId) {
        this.dblindExConditionDetailByConditionDetailId = dblindExConditionDetailByConditionDetailId;
    }
}
