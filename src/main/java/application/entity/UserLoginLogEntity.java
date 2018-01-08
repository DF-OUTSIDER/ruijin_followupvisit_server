package application.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "UserLoginLog", schema = "dbo")
public class UserLoginLogEntity {
    private int userLoginLogId;
    private String userId;
    private String ipAddress;
    private Timestamp loginTime;
    private UserEntity userByUserId;

    @Id
    @Column(name = "UserLoginLogId", nullable = false)
    public int getUserLoginLogId() {
        return userLoginLogId;
    }

    public void setUserLoginLogId(int userLoginLogId) {
        this.userLoginLogId = userLoginLogId;
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
    @Column(name = "IPAddress", nullable = false, length = 15)
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Basic
    @Column(name = "LoginTime", nullable = false)
    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLoginLogEntity that = (UserLoginLogEntity) o;
        return userLoginLogId == that.userLoginLogId &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(ipAddress, that.ipAddress) &&
                Objects.equals(loginTime, that.loginTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userLoginLogId, userId, ipAddress, loginTime);
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
