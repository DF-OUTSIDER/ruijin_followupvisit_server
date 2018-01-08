package application.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Token", schema = "dbo")
public class TokenEntity {
    private String userId;
    private String token;
    private long expiresIn;
    private long createTime;
    private Timestamp createDate;
    private AppUserEntity appUserByUserId;

    @Id
    @Column(name = "UserId", nullable = false, length = 32)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "Token", nullable = false, length = 100)
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Basic
    @Column(name = "ExpiresIn", nullable = false)
    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    @Basic
    @Column(name = "CreateTime", nullable = false)
    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "CreateDate", nullable = false)
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TokenEntity that = (TokenEntity) o;
        return expiresIn == that.expiresIn &&
                createTime == that.createTime &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(token, that.token) &&
                Objects.equals(createDate, that.createDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, token, expiresIn, createTime, createDate);
    }

    @OneToOne
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false)
    public AppUserEntity getAppUserByUserId() {
        return appUserByUserId;
    }

    public void setAppUserByUserId(AppUserEntity appUserByUserId) {
        this.appUserByUserId = appUserByUserId;
    }
}
