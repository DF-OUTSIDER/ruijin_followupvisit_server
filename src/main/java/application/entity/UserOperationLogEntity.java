package application.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "UserOperationLog", schema = "dbo")
public class UserOperationLogEntity {
    private int userOperationLogId;
    private String userId;
    private String operationName;
    private String content;
    private Timestamp operationTime;
    private String externalUserName;
    private String externalEmployeeNumber;
    private UserEntity userByUserId;

    @Id
    @Column(name = "UserOperationLogId", nullable = false)
    public int getUserOperationLogId() {
        return userOperationLogId;
    }

    public void setUserOperationLogId(int userOperationLogId) {
        this.userOperationLogId = userOperationLogId;
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
    @Column(name = "OperationName", nullable = false, length = 100)
    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    @Basic
    @Column(name = "Content", nullable = false, length = 1000)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "OperationTime", nullable = false)
    public Timestamp getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Timestamp operationTime) {
        this.operationTime = operationTime;
    }

    @Basic
    @Column(name = "ExternalUserName", nullable = true, length = 20)
    public String getExternalUserName() {
        return externalUserName;
    }

    public void setExternalUserName(String externalUserName) {
        this.externalUserName = externalUserName;
    }

    @Basic
    @Column(name = "ExternalEmployeeNumber", nullable = true, length = 20)
    public String getExternalEmployeeNumber() {
        return externalEmployeeNumber;
    }

    public void setExternalEmployeeNumber(String externalEmployeeNumber) {
        this.externalEmployeeNumber = externalEmployeeNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserOperationLogEntity that = (UserOperationLogEntity) o;
        return userOperationLogId == that.userOperationLogId &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(operationName, that.operationName) &&
                Objects.equals(content, that.content) &&
                Objects.equals(operationTime, that.operationTime) &&
                Objects.equals(externalUserName, that.externalUserName) &&
                Objects.equals(externalEmployeeNumber, that.externalEmployeeNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userOperationLogId, userId, operationName, content, operationTime, externalUserName, externalEmployeeNumber);
    }

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false, insertable = false, updatable = false)
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }
}
