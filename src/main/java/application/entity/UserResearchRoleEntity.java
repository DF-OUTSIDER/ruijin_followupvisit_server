package application.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "UserResearchRole", schema = "dbo")
public class UserResearchRoleEntity {
    private String userResearchRoleId;
    private String userResearchId;
    private int roleId;
    private UserResearchEntity userResearchByUserResearchId;
    private RoleEntity roleByRoleId;

    @Id
    @Column(name = "UserResearchRoleId", nullable = false, length = 32)
    public String getUserResearchRoleId() {
        return userResearchRoleId;
    }

    public void setUserResearchRoleId(String userResearchRoleId) {
        this.userResearchRoleId = userResearchRoleId;
    }

    @Basic
    @Column(name = "UserResearchId", nullable = false, length = 32)
    public String getUserResearchId() {
        return userResearchId;
    }

    public void setUserResearchId(String userResearchId) {
        this.userResearchId = userResearchId;
    }

    @Basic
    @Column(name = "RoleId", nullable = false)
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserResearchRoleEntity that = (UserResearchRoleEntity) o;
        return roleId == that.roleId &&
                Objects.equals(userResearchRoleId, that.userResearchRoleId) &&
                Objects.equals(userResearchId, that.userResearchId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userResearchRoleId, userResearchId, roleId);
    }

    @ManyToOne
    @JoinColumn(name = "UserResearchId", referencedColumnName = "UserResearchId", nullable = false, insertable = false, updatable = false)
    public UserResearchEntity getUserResearchByUserResearchId() {
        return userResearchByUserResearchId;
    }

    public void setUserResearchByUserResearchId(UserResearchEntity userResearchByUserResearchId) {
        this.userResearchByUserResearchId = userResearchByUserResearchId;
    }

    @ManyToOne
    @JoinColumn(name = "RoleId", referencedColumnName = "RoleId", nullable = false, insertable = false, updatable = false)
    public RoleEntity getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(RoleEntity roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }
}
