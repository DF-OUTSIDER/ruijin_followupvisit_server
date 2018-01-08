package application.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "DblindExConditionDetail", schema = "dbo")
public class DblindExConditionDetailEntity {
    private int conditionDetailId;
    private int conditionId;
    private String optionText;
    private String optionRemark;
    private DblindExConditionEntity dblindExConditionByConditionId;
    private Collection<UserDblindConditionAnswerEntity> userDblindConditionAnswersByConditionDetailId;

    @Id
    @Column(name = "ConditionDetailId", nullable = false)
    public int getConditionDetailId() {
        return conditionDetailId;
    }

    public void setConditionDetailId(int conditionDetailId) {
        this.conditionDetailId = conditionDetailId;
    }

    @Basic
    @Column(name = "ConditionId", nullable = false)
    public int getConditionId() {
        return conditionId;
    }

    public void setConditionId(int conditionId) {
        this.conditionId = conditionId;
    }

    @Basic
    @Column(name = "OptionText", nullable = false, length = 100)
    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    @Basic
    @Column(name = "OptionRemark", nullable = false, length = 500)
    public String getOptionRemark() {
        return optionRemark;
    }

    public void setOptionRemark(String optionRemark) {
        this.optionRemark = optionRemark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DblindExConditionDetailEntity that = (DblindExConditionDetailEntity) o;
        return conditionDetailId == that.conditionDetailId &&
                conditionId == that.conditionId &&
                Objects.equals(optionText, that.optionText) &&
                Objects.equals(optionRemark, that.optionRemark);
    }

    @Override
    public int hashCode() {

        return Objects.hash(conditionDetailId, conditionId, optionText, optionRemark);
    }

    @ManyToOne
    @JoinColumn(name = "ConditionId", referencedColumnName = "ConditionId", nullable = false, insertable = false, updatable = false)
    public DblindExConditionEntity getDblindExConditionByConditionId() {
        return dblindExConditionByConditionId;
    }

    public void setDblindExConditionByConditionId(DblindExConditionEntity dblindExConditionByConditionId) {
        this.dblindExConditionByConditionId = dblindExConditionByConditionId;
    }

    @OneToMany(mappedBy = "dblindExConditionDetailByConditionDetailId")
    public Collection<UserDblindConditionAnswerEntity> getUserDblindConditionAnswersByConditionDetailId() {
        return userDblindConditionAnswersByConditionDetailId;
    }

    public void setUserDblindConditionAnswersByConditionDetailId(Collection<UserDblindConditionAnswerEntity> userDblindConditionAnswersByConditionDetailId) {
        this.userDblindConditionAnswersByConditionDetailId = userDblindConditionAnswersByConditionDetailId;
    }
}
