package application.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "UserRole", schema = "dbo")
public class UserRoleEntity {
    private int userRoleId;
    private String userId;
    private Integer roleId;
    private UserEntity userByUserId;
    private RoleEntity roleByRoleId;

    @Id
    @Column(name = "UserRoleId", nullable = false)
    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
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
    @Column(name = "RoleId", nullable = true)
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRoleEntity that = (UserRoleEntity) o;
        return userRoleId == that.userRoleId &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(roleId, that.roleId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userRoleId, userId, roleId);
    }

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false, insertable = false, updatable = false)
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "RoleId", referencedColumnName = "RoleId", insertable = false, updatable = false)
    public RoleEntity getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(RoleEntity roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }
}
