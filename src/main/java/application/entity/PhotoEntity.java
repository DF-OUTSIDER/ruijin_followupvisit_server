package application.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Photo", schema = "dbo")
public class PhotoEntity {
    private String photoId;
    private String photoTypeId;
    private String visitId;
    private String userId;
    private String path;
    private String description;
    private Timestamp updDate;
    private PhotoTypeEntity photoTypeByPhotoTypeId;
    private VisitEntity visitByVisitId;
    private AppUserEntity appUserByUserId;

    @Id
    @Column(name = "PhotoId", nullable = false, length = 32)
    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    @Basic
    @Column(name = "PhotoTypeId", nullable = false, length = 32)
    public String getPhotoTypeId() {
        return photoTypeId;
    }

    public void setPhotoTypeId(String photoTypeId) {
        this.photoTypeId = photoTypeId;
    }

    @Basic
    @Column(name = "VisitId", nullable = false, length = 32)
    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
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
    @Column(name = "Path", nullable = false, length = 100)
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
    @Column(name = "UpdDate", nullable = false)
    public Timestamp getUpdDate() {
        return updDate;
    }

    public void setUpdDate(Timestamp updDate) {
        this.updDate = updDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhotoEntity that = (PhotoEntity) o;
        return Objects.equals(photoId, that.photoId) &&
                Objects.equals(photoTypeId, that.photoTypeId) &&
                Objects.equals(visitId, that.visitId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(path, that.path) &&
                Objects.equals(description, that.description) &&
                Objects.equals(updDate, that.updDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(photoId, photoTypeId, visitId, userId, path, description, updDate);
    }

    @ManyToOne
    @JoinColumn(name = "PhotoTypeId", referencedColumnName = "PhotoTypeId", nullable = false, insertable = false, updatable = false)
    public PhotoTypeEntity getPhotoTypeByPhotoTypeId() {
        return photoTypeByPhotoTypeId;
    }

    public void setPhotoTypeByPhotoTypeId(PhotoTypeEntity photoTypeByPhotoTypeId) {
        this.photoTypeByPhotoTypeId = photoTypeByPhotoTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "VisitId", referencedColumnName = "VisitId", nullable = false, insertable = false, updatable = false)
    public VisitEntity getVisitByVisitId() {
        return visitByVisitId;
    }

    public void setVisitByVisitId(VisitEntity visitByVisitId) {
        this.visitByVisitId = visitByVisitId;
    }

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false, insertable = false, updatable = false)
    public AppUserEntity getAppUserByUserId() {
        return appUserByUserId;
    }

    public void setAppUserByUserId(AppUserEntity appUserByUserId) {
        this.appUserByUserId = appUserByUserId;
    }
}
