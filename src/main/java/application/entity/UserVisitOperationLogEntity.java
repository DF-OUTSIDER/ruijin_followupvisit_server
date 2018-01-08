package application.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "UserVisitOperationLog", schema = "dbo")
public class UserVisitOperationLogEntity {
    private String userVisitOperationLogId;
    private String userId;
    private String visitId;
    private String description;
    private Timestamp createDate;
    private String operation;
    private UserEntity userByUserId;
    private VisitEntity visitByVisitId;

    @Id
    @Column(name = "UserVisitOperationLogId", nullable = false, length = 32)
    public String getUserVisitOperationLogId() {
        return userVisitOperationLogId;
    }

    public void setUserVisitOperationLogId(String userVisitOperationLogId) {
        this.userVisitOperationLogId = userVisitOperationLogId;
    }

    @Basic
    @Column(name = "UserId", nullable = true, length = 32)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "VisitId", nullable = true, length = 32)
    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    @Basic
    @Column(name = "Description", nullable = true, length = 100)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    @Column(name = "Operation", nullable = false, length = 32)
    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserVisitOperationLogEntity that = (UserVisitOperationLogEntity) o;
        return Objects.equals(userVisitOperationLogId, that.userVisitOperationLogId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(visitId, that.visitId) &&
                Objects.equals(description, that.description) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(operation, that.operation);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userVisitOperationLogId, userId, visitId, description, createDate, operation);
    }

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", insertable = false, updatable = false)
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "VisitId", referencedColumnName = "VisitId", insertable = false, updatable = false)
    public VisitEntity getVisitByVisitId() {
        return visitByVisitId;
    }

    public void setVisitByVisitId(VisitEntity visitByVisitId) {
        this.visitByVisitId = visitByVisitId;
    }
}
