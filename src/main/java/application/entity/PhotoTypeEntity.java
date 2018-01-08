package application.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "PhotoType", schema = "dbo")
public class PhotoTypeEntity {
    private String photoTypeId;
    private String typeName;
    private String description;
    private Collection<PhotoEntity> photosByPhotoTypeId;

    @Id
    @Column(name = "PhotoTypeId", nullable = false, length = 32)
    public String getPhotoTypeId() {
        return photoTypeId;
    }

    public void setPhotoTypeId(String photoTypeId) {
        this.photoTypeId = photoTypeId;
    }

    @Basic
    @Column(name = "TypeName", nullable = false, length = 20)
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Basic
    @Column(name = "Description", nullable = true, length = 200)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhotoTypeEntity that = (PhotoTypeEntity) o;
        return Objects.equals(photoTypeId, that.photoTypeId) &&
                Objects.equals(typeName, that.typeName) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(photoTypeId, typeName, description);
    }

    @OneToMany(mappedBy = "photoTypeByPhotoTypeId")
    public Collection<PhotoEntity> getPhotosByPhotoTypeId() {
        return photosByPhotoTypeId;
    }

    public void setPhotosByPhotoTypeId(Collection<PhotoEntity> photosByPhotoTypeId) {
        this.photosByPhotoTypeId = photosByPhotoTypeId;
    }
}
