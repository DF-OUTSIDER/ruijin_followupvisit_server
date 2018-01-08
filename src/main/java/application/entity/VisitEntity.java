package application.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Visit", schema = "dbo")
public class VisitEntity {
    private String visitId;
    private String hdId;
    private String userCardHospitalDiseaseId;
    private boolean isDel;
    private Timestamp createDate;
    private Timestamp updDate;
    private String title;
    private String content;
    private Timestamp suggestDate;
    private Timestamp windowStart;
    private Timestamp windowEnd;
    private Timestamp visitDate;
    private String visitType;
    private String visitStatus;
    private Collection<CrfEntity> crfsByVisitId;
    private Collection<OrderEntity> ordersByVisitId;
    private Collection<PhotoEntity> photosByVisitId;
    private Collection<UserMedicineEntity> userMedicinesByVisitId;
    private Collection<UserVisitOperationLogEntity> userVisitOperationLogsByVisitId;
    private HospitalResearchEntity hospitalResearchByHdId;
    private UserCardGroupEntity userCardGroupByUserCardHospitalDiseaseId;

    @Id
    @Column(name = "VisitId", nullable = false, length = 32)
    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    @Basic
    @Column(name = "HDId", nullable = false, length = 32)
    public String getHdId() {
        return hdId;
    }

    public void setHdId(String hdId) {
        this.hdId = hdId;
    }

    @Basic
    @Column(name = "UserCardHospitalDiseaseId", nullable = true, length = 32)
    public String getUserCardHospitalDiseaseId() {
        return userCardHospitalDiseaseId;
    }

    public void setUserCardHospitalDiseaseId(String userCardHospitalDiseaseId) {
        this.userCardHospitalDiseaseId = userCardHospitalDiseaseId;
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
    @Column(name = "CreateDate", nullable = false)
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "UpdDate", nullable = false)
    public Timestamp getUpdDate() {
        return updDate;
    }

    public void setUpdDate(Timestamp updDate) {
        this.updDate = updDate;
    }

    @Basic
    @Column(name = "Title", nullable = false, length = 500)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "Content", nullable = true, length = 500)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "SuggestDate", nullable = false)
    public Timestamp getSuggestDate() {
        return suggestDate;
    }

    public void setSuggestDate(Timestamp suggestDate) {
        this.suggestDate = suggestDate;
    }

    @Basic
    @Column(name = "WindowStart", nullable = false)
    public Timestamp getWindowStart() {
        return windowStart;
    }

    public void setWindowStart(Timestamp windowStart) {
        this.windowStart = windowStart;
    }

    @Basic
    @Column(name = "WindowEnd", nullable = false)
    public Timestamp getWindowEnd() {
        return windowEnd;
    }

    public void setWindowEnd(Timestamp windowEnd) {
        this.windowEnd = windowEnd;
    }

    @Basic
    @Column(name = "VisitDate", nullable = false)
    public Timestamp getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Timestamp visitDate) {
        this.visitDate = visitDate;
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
    @Column(name = "VisitStatus", nullable = false, length = 20)
    public String getVisitStatus() {
        return visitStatus;
    }

    public void setVisitStatus(String visitStatus) {
        this.visitStatus = visitStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitEntity that = (VisitEntity) o;
        return isDel == that.isDel &&
                Objects.equals(visitId, that.visitId) &&
                Objects.equals(hdId, that.hdId) &&
                Objects.equals(userCardHospitalDiseaseId, that.userCardHospitalDiseaseId) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(updDate, that.updDate) &&
                Objects.equals(title, that.title) &&
                Objects.equals(content, that.content) &&
                Objects.equals(suggestDate, that.suggestDate) &&
                Objects.equals(windowStart, that.windowStart) &&
                Objects.equals(windowEnd, that.windowEnd) &&
                Objects.equals(visitDate, that.visitDate) &&
                Objects.equals(visitType, that.visitType) &&
                Objects.equals(visitStatus, that.visitStatus);
    }

    @Override
    public int hashCode() {

        return Objects.hash(visitId, hdId, userCardHospitalDiseaseId, isDel, createDate, updDate, title, content, suggestDate, windowStart, windowEnd, visitDate, visitType, visitStatus);
    }

    @OneToMany(mappedBy = "visitByVisitId")
    public Collection<CrfEntity> getCrfsByVisitId() {
        return crfsByVisitId;
    }

    public void setCrfsByVisitId(Collection<CrfEntity> crfsByVisitId) {
        this.crfsByVisitId = crfsByVisitId;
    }

    @OneToMany(mappedBy = "visitByVisitId")
    public Collection<OrderEntity> getOrdersByVisitId() {
        return ordersByVisitId;
    }

    public void setOrdersByVisitId(Collection<OrderEntity> ordersByVisitId) {
        this.ordersByVisitId = ordersByVisitId;
    }

    @OneToMany(mappedBy = "visitByVisitId")
    public Collection<PhotoEntity> getPhotosByVisitId() {
        return photosByVisitId;
    }

    public void setPhotosByVisitId(Collection<PhotoEntity> photosByVisitId) {
        this.photosByVisitId = photosByVisitId;
    }

    @OneToMany(mappedBy = "visitByVisitId")
    public Collection<UserMedicineEntity> getUserMedicinesByVisitId() {
        return userMedicinesByVisitId;
    }

    public void setUserMedicinesByVisitId(Collection<UserMedicineEntity> userMedicinesByVisitId) {
        this.userMedicinesByVisitId = userMedicinesByVisitId;
    }

    @OneToMany(mappedBy = "visitByVisitId")
    public Collection<UserVisitOperationLogEntity> getUserVisitOperationLogsByVisitId() {
        return userVisitOperationLogsByVisitId;
    }

    public void setUserVisitOperationLogsByVisitId(Collection<UserVisitOperationLogEntity> userVisitOperationLogsByVisitId) {
        this.userVisitOperationLogsByVisitId = userVisitOperationLogsByVisitId;
    }

    @ManyToOne
    @JoinColumn(name = "HDId", referencedColumnName = "HospitalResearchId", nullable = false, insertable = false, updatable = false)
    public HospitalResearchEntity getHospitalResearchByHdId() {
        return hospitalResearchByHdId;
    }

    public void setHospitalResearchByHdId(HospitalResearchEntity hospitalResearchByHdId) {
        this.hospitalResearchByHdId = hospitalResearchByHdId;
    }

    @ManyToOne
    @JoinColumn(name = "UserCardHospitalDiseaseId", referencedColumnName = "UserCardHospitalDiseaseId", insertable = false, updatable = false)
    public UserCardGroupEntity getUserCardGroupByUserCardHospitalDiseaseId() {
        return userCardGroupByUserCardHospitalDiseaseId;
    }

    public void setUserCardGroupByUserCardHospitalDiseaseId(UserCardGroupEntity userCardGroupByUserCardHospitalDiseaseId) {
        this.userCardGroupByUserCardHospitalDiseaseId = userCardGroupByUserCardHospitalDiseaseId;
    }
}
