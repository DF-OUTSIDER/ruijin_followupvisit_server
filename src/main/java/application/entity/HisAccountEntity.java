package application.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "HisAccount", schema = "dbo")
public class HisAccountEntity {
    private int id;
    private String userId;
    private String accountName;
    private String lastLoginIp;
    private Timestamp lastLoginTime;
    private boolean isValid;
    private UserEntity userByUserId;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "AccountName", nullable = false, length = 150)
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Basic
    @Column(name = "LastLoginIp", nullable = false, length = 50)
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    @Basic
    @Column(name = "LastLoginTime", nullable = false)
    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
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
        HisAccountEntity that = (HisAccountEntity) o;
        return id == that.id &&
                isValid == that.isValid &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(accountName, that.accountName) &&
                Objects.equals(lastLoginIp, that.lastLoginIp) &&
                Objects.equals(lastLoginTime, that.lastLoginTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, accountName, lastLoginIp, lastLoginTime, isValid);
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
