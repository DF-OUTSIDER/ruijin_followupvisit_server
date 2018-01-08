package application.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "UserResearch", schema = "dbo")
public class UserResearchEntity {
    private String userResearchId;
    private String researchId;
    private String userId;
    private ResearchEntity researchByResearchId;
    private UserEntity userByUserId;
    private Collection<UserResearchRoleEntity> userResearchRolesByUserResearchId;

    @Id
    @Column(name = "UserResearchId", nullable = false, length = 32)
    public String getUserResearchId() {
        return userResearchId;
    }

    public void setUserResearchId(String userResearchId) {
        this.userResearchId = userResearchId;
    }

    @Basic
    @Column(name = "ResearchId", nullable = false, length = 32)
    public String getResearchId() {
        return researchId;
    }

    public void setResearchId(String researchId) {
        this.researchId = researchId;
    }

    @Basic
    @Column(name = "UserId", nullable = false, length = 32)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserResearchEntity that = (UserResearchEntity) o;
        return Objects.equals(userResearchId, that.userResearchId) &&
                Objects.equals(researchId, that.researchId) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userResearchId, researchId, userId);
    }

    @ManyToOne
    @JoinColumn(name = "ResearchId", referencedColumnName = "ResearchId", nullable = false, insertable = false, updatable = false)
    public ResearchEntity getResearchByResearchId() {
        return researchByResearchId;
    }

    public void setResearchByResearchId(ResearchEntity researchByResearchId) {
        this.researchByResearchId = researchByResearchId;
    }

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false, insertable = false, updatable = false)
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    @OneToMany(mappedBy = "userResearchByUserResearchId")
    public Collection<UserResearchRoleEntity> getUserResearchRolesByUserResearchId() {
        return userResearchRolesByUserResearchId;
    }

    public void setUserResearchRolesByUserResearchId(Collection<UserResearchRoleEntity> userResearchRolesByUserResearchId) {
        this.userResearchRolesByUserResearchId = userResearchRolesByUserResearchId;
    }
}
