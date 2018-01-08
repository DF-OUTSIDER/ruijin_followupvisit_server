package application.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Operation", schema = "dbo")
public class OperationEntity {
    private int operationId;
    private String operationName;
    private String category;
    private String description;
    private String url;
    private Collection<RoleOperationEntity> roleOperationsByOperationId;

    @Id
    @Column(name = "OperationId", nullable = false)
    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }

    @Basic
    @Column(name = "OperationName", nullable = false, length = 50)
    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    @Basic
    @Column(name = "Category", nullable = false, length = 50)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Column(name = "Description", nullable = false, length = 500)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "Url", nullable = false, length = 500)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationEntity that = (OperationEntity) o;
        return operationId == that.operationId &&
                Objects.equals(operationName, that.operationName) &&
                Objects.equals(category, that.category) &&
                Objects.equals(description, that.description) &&
                Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {

        return Objects.hash(operationId, operationName, category, description, url);
    }

    @OneToMany(mappedBy = "operationByOperationId")
    public Collection<RoleOperationEntity> getRoleOperationsByOperationId() {
        return roleOperationsByOperationId;
    }

    public void setRoleOperationsByOperationId(Collection<RoleOperationEntity> roleOperationsByOperationId) {
        this.roleOperationsByOperationId = roleOperationsByOperationId;
    }
}
