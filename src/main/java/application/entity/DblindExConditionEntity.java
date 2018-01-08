package application.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "DblindExCondition", schema = "dbo")
public class DblindExConditionEntity {
    private int conditionId;
    private String researchId;
    private String conditionName;
    private ResearchEntity researchByResearchId;
    private Collection<DblindExConditionDetailEntity> dblindExConditionDetailsByConditionId;

    @Id
    @Column(name = "ConditionId", nullable = false)
    public int getConditionId() {
        return conditionId;
    }

    public void setConditionId(int conditionId) {
        this.conditionId = conditionId;
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
    @Column(name = "ConditionName", nullable = false, length = 100)
    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DblindExConditionEntity that = (DblindExConditionEntity) o;
        return conditionId == that.conditionId &&
                Objects.equals(researchId, that.researchId) &&
                Objects.equals(conditionName, that.conditionName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(conditionId, researchId, conditionName);
    }

    @ManyToOne
    @JoinColumn(name = "ResearchId", referencedColumnName = "ResearchId", nullable = false, insertable = false, updatable = false)
    public ResearchEntity getResearchByResearchId() {
        return researchByResearchId;
    }

    public void setResearchByResearchId(ResearchEntity researchByResearchId) {
        this.researchByResearchId = researchByResearchId;
    }

    @OneToMany(mappedBy = "dblindExConditionByConditionId")
    public Collection<DblindExConditionDetailEntity> getDblindExConditionDetailsByConditionId() {
        return dblindExConditionDetailsByConditionId;
    }

    public void setDblindExConditionDetailsByConditionId(Collection<DblindExConditionDetailEntity> dblindExConditionDetailsByConditionId) {
        this.dblindExConditionDetailsByConditionId = dblindExConditionDetailsByConditionId;
    }
}
