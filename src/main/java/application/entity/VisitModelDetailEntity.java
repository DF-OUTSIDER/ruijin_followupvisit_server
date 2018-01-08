package application.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "VisitModelDetail", schema = "dbo")
public class VisitModelDetailEntity {
    private int visitModelDetailId;
    private String visitModelId;
    private int gapDays;
    private int windowDays;
    private String visitType;
    private String title;
    private String content;
    private int visitOrder;
    private VisitModelEntity visitModelByVisitModelId;
    private Collection<VisitModelSheetTemplateEntity> visitModelSheetTemplatesByVisitModelDetailId;

    @Id
    @Column(name = "VisitModelDetailId", nullable = false)
    public int getVisitModelDetailId() {
        return visitModelDetailId;
    }

    public void setVisitModelDetailId(int visitModelDetailId) {
        this.visitModelDetailId = visitModelDetailId;
    }

    @Basic
    @Column(name = "VisitModelId", nullable = false, length = 32)
    public String getVisitModelId() {
        return visitModelId;
    }

    public void setVisitModelId(String visitModelId) {
        this.visitModelId = visitModelId;
    }

    @Basic
    @Column(name = "GapDays", nullable = false)
    public int getGapDays() {
        return gapDays;
    }

    public void setGapDays(int gapDays) {
        this.gapDays = gapDays;
    }

    @Basic
    @Column(name = "WindowDays", nullable = false)
    public int getWindowDays() {
        return windowDays;
    }

    public void setWindowDays(int windowDays) {
        this.windowDays = windowDays;
    }

    @Basic
    @Column(name = "VisitType", nullable = false, length = 20)
    public String getVisitType() {
        return visitType;
    }

    public void setVisitType(String visitType) {
        this.visitType = visitType;
    }

    @Basic
    @Column(name = "Title", nullable = false, length = 200)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "Content", nullable = false, length = 500)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "VisitOrder", nullable = false)
    public int getVisitOrder() {
        return visitOrder;
    }

    public void setVisitOrder(int visitOrder) {
        this.visitOrder = visitOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitModelDetailEntity that = (VisitModelDetailEntity) o;
        return visitModelDetailId == that.visitModelDetailId &&
                gapDays == that.gapDays &&
                windowDays == that.windowDays &&
                visitOrder == that.visitOrder &&
                Objects.equals(visitModelId, that.visitModelId) &&
                Objects.equals(visitType, that.visitType) &&
                Objects.equals(title, that.title) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {

        return Objects.hash(visitModelDetailId, visitModelId, gapDays, windowDays, visitType, title, content, visitOrder);
    }

    @ManyToOne
    @JoinColumn(name = "VisitModelId", referencedColumnName = "VisitModelId", nullable = false, insertable = false, updatable = false)
    public VisitModelEntity getVisitModelByVisitModelId() {
        return visitModelByVisitModelId;
    }

    public void setVisitModelByVisitModelId(VisitModelEntity visitModelByVisitModelId) {
        this.visitModelByVisitModelId = visitModelByVisitModelId;
    }

    @OneToMany(mappedBy = "visitModelDetailByVisitModelDetailId")
    public Collection<VisitModelSheetTemplateEntity> getVisitModelSheetTemplatesByVisitModelDetailId() {
        return visitModelSheetTemplatesByVisitModelDetailId;
    }

    public void setVisitModelSheetTemplatesByVisitModelDetailId(Collection<VisitModelSheetTemplateEntity> visitModelSheetTemplatesByVisitModelDetailId) {
        this.visitModelSheetTemplatesByVisitModelDetailId = visitModelSheetTemplatesByVisitModelDetailId;
    }
}
