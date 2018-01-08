package application.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "VisitModelSheetTemplate", schema = "dbo")
public class VisitModelSheetTemplateEntity {
    private int visitModelSheetTemplateId;
    private int sheetTemplateId;
    private int visitModelDetailId;
    private SheetTemplateEntity sheetTemplateBySheetTemplateId;
    private VisitModelDetailEntity visitModelDetailByVisitModelDetailId;

    @Id
    @Column(name = "VisitModelSheetTemplateId", nullable = false)
    public int getVisitModelSheetTemplateId() {
        return visitModelSheetTemplateId;
    }

    public void setVisitModelSheetTemplateId(int visitModelSheetTemplateId) {
        this.visitModelSheetTemplateId = visitModelSheetTemplateId;
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
    @Column(name = "VisitModelDetailId", nullable = false)
    public int getVisitModelDetailId() {
        return visitModelDetailId;
    }

    public void setVisitModelDetailId(int visitModelDetailId) {
        this.visitModelDetailId = visitModelDetailId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitModelSheetTemplateEntity that = (VisitModelSheetTemplateEntity) o;
        return visitModelSheetTemplateId == that.visitModelSheetTemplateId &&
                sheetTemplateId == that.sheetTemplateId &&
                visitModelDetailId == that.visitModelDetailId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(visitModelSheetTemplateId, sheetTemplateId, visitModelDetailId);
    }

    @ManyToOne
    @JoinColumn(name = "SheetTemplateId", referencedColumnName = "SheetTemplateId", nullable = false, insertable = false, updatable = false)
    public SheetTemplateEntity getSheetTemplateBySheetTemplateId() {
        return sheetTemplateBySheetTemplateId;
    }

    public void setSheetTemplateBySheetTemplateId(SheetTemplateEntity sheetTemplateBySheetTemplateId) {
        this.sheetTemplateBySheetTemplateId = sheetTemplateBySheetTemplateId;
    }

    @ManyToOne
    @JoinColumn(name = "VisitModelDetailId", referencedColumnName = "VisitModelDetailId", nullable = false, insertable = false, updatable = false)
    public VisitModelDetailEntity getVisitModelDetailByVisitModelDetailId() {
        return visitModelDetailByVisitModelDetailId;
    }

    public void setVisitModelDetailByVisitModelDetailId(VisitModelDetailEntity visitModelDetailByVisitModelDetailId) {
        this.visitModelDetailByVisitModelDetailId = visitModelDetailByVisitModelDetailId;
    }
}
