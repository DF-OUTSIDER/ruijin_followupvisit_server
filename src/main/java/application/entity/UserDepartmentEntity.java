package application.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "UserDepartment", schema = "dbo")
public class UserDepartmentEntity {
    private int userDeptId;
    private String userId;
    private String deptId;
    private UserEntity userByUserId;
    private DepartmentEntity departmentByDeptId;

    @Id
    @Column(name = "UserDeptId", nullable = false)
    public int getUserDeptId() {
        return userDeptId;
    }

    public void setUserDeptId(int userDeptId) {
        this.userDeptId = userDeptId;
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
    @Column(name = "DeptId", nullable = false, length = 32)
    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDepartmentEntity that = (UserDepartmentEntity) o;
        return userDeptId == that.userDeptId &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(deptId, that.deptId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userDeptId, userId, deptId);
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
    @JoinColumn(name = "DeptId", referencedColumnName = "DeptId", nullable = false, insertable = false, updatable = false)
    public DepartmentEntity getDepartmentByDeptId() {
        return departmentByDeptId;
    }

    public void setDepartmentByDeptId(DepartmentEntity departmentByDeptId) {
        this.departmentByDeptId = departmentByDeptId;
    }
}
