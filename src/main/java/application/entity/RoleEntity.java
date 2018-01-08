package application.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Role", schema = "dbo")
public class RoleEntity {
    private int roleId;
    private String roleName;
    private boolean preDefined;
    private String description;
    private boolean superUserRole;
    private Collection<RoleOperationEntity> roleOperationsByRoleId;
    private Collection<UserResearchRoleEntity> userResearchRolesByRoleId;
    private Collection<UserRoleEntity> userRolesByRoleId;

    @Id
    @Column(name = "RoleId", nullable = false)
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "RoleName", nullable = false, length = 50)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "PreDefined", nullable = false)
    public boolean isPreDefined() {
        return preDefined;
    }

    public void setPreDefined(boolean preDefined) {
        this.preDefined = preDefined;
    }

    @Basic
    @Column(name = "Description", nullable = true, length = 500)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "SuperUserRole", nullable = false)
    public boolean isSuperUserRole() {
        return superUserRole;
    }

    public void setSuperUserRole(boolean superUserRole) {
        this.superUserRole = superUserRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return roleId == that.roleId &&
                preDefined == that.preDefined &&
                superUserRole == that.superUserRole &&
                Objects.equals(roleName, that.roleName) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(roleId, roleName, preDefined, description, superUserRole);
    }

    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<RoleOperationEntity> getRoleOperationsByRoleId() {
        return roleOperationsByRoleId;
    }

    public void setRoleOperationsByRoleId(Collection<RoleOperationEntity> roleOperationsByRoleId) {
        this.roleOperationsByRoleId = roleOperationsByRoleId;
    }

    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<UserResearchRoleEntity> getUserResearchRolesByRoleId() {
        return userResearchRolesByRoleId;
    }

    public void setUserResearchRolesByRoleId(Collection<UserResearchRoleEntity> userResearchRolesByRoleId) {
        this.userResearchRolesByRoleId = userResearchRolesByRoleId;
    }

    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<UserRoleEntity> getUserRolesByRoleId() {
        return userRolesByRoleId;
    }

    public void setUserRolesByRoleId(Collection<UserRoleEntity> userRolesByRoleId) {
        this.userRolesByRoleId = userRolesByRoleId;
    }
}
