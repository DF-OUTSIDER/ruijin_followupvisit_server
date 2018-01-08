package application.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "VisitModel", schema = "dbo")
public class VisitModelEntity {
    private String visitModelId;
    private String researchId;
    private String visitModelName;
    private String description;
    private boolean isValid;
    private ResearchEntity researchByResearchId;
    private Collection<VisitModelDetailEntity> visitModelDetailsByVisitModelId;

    @Id
    @Column(name = "VisitModelId", nullable = false, length = 32)
    public String getVisitModelId() {
        return visitModelId;
    }

    public void setVisitModelId(String visitModelId) {
        this.visitModelId = visitModelId;
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
    @Column(name = "VisitModelName", nullable = false, length = 50)
    public String getVisitModelName() {
        return visitModelName;
    }

    public void setVisitModelName(String visitModelName) {
        this.visitModelName = visitModelName;
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
    @Column(name = "IsValid", nullable = false)
    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitModelEntity that = (VisitModelEntity) o;
        return isValid == that.isValid &&
                Objects.equals(visitModelId, that.visitModelId) &&
                Objects.equals(researchId, that.researchId) &&
                Objects.equals(visitModelName, that.visitModelName) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(visitModelId, researchId, visitModelName, description, isValid);
    }

    @ManyToOne
    @JoinColumn(name = "ResearchId", referencedColumnName = "ResearchId", nullable = false, insertable = false, updatable = false)
    public ResearchEntity getResearchByResearchId() {
        return researchByResearchId;
    }

    public void setResearchByResearchId(ResearchEntity researchByResearchId) {
        this.researchByResearchId = researchByResearchId;
    }

    @OneToMany(mappedBy = "visitModelByVisitModelId")
    public Collection<VisitModelDetailEntity> getVisitModelDetailsByVisitModelId() {
        return visitModelDetailsByVisitModelId;
    }

    public void setVisitModelDetailsByVisitModelId(Collection<VisitModelDetailEntity> visitModelDetailsByVisitModelId) {
        this.visitModelDetailsByVisitModelId = visitModelDetailsByVisitModelId;
    }
}
