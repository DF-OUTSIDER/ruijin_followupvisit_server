package application.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "UserCard", schema = "dbo")
public class UserCardEntity {
    private String userCardId;
    private String userId;
    private String cardType;
    private String cardNo;
    private boolean isValid;
    private String userNo;
    private AppUserEntity appUserByUserId;
    private Collection<UserCardGroupEntity> userCardGroupsByUserCardId;

    @Id
    @Column(name = "UserCardId", nullable = false, length = 32)
    public String getUserCardId() {
        return userCardId;
    }

    public void setUserCardId(String userCardId) {
        this.userCardId = userCardId;
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
    @Column(name = "CardType", nullable = false, length = 20)
    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Basic
    @Column(name = "CardNo", nullable = false, length = 50)
    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    @Basic
    @Column(name = "IsValid", nullable = false)
    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    @Basic
    @Column(name = "UserNo", nullable = true, length = 150)
    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCardEntity that = (UserCardEntity) o;
        return isValid == that.isValid &&
                Objects.equals(userCardId, that.userCardId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(cardType, that.cardType) &&
                Objects.equals(cardNo, that.cardNo) &&
                Objects.equals(userNo, that.userNo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userCardId, userId, cardType, cardNo, isValid, userNo);
    }

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false, insertable = false, updatable = false)
    public AppUserEntity getAppUserByUserId() {
        return appUserByUserId;
    }

    public void setAppUserByUserId(AppUserEntity appUserByUserId) {
        this.appUserByUserId = appUserByUserId;
    }

    @OneToMany(mappedBy = "userCardByUserCardId")
    public Collection<UserCardGroupEntity> getUserCardGroupsByUserCardId() {
        return userCardGroupsByUserCardId;
    }

    public void setUserCardGroupsByUserCardId(Collection<UserCardGroupEntity> userCardGroupsByUserCardId) {
        this.userCardGroupsByUserCardId = userCardGroupsByUserCardId;
    }
}
