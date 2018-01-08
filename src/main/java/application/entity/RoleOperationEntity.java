package application.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "RoleOperation", schema = "dbo")
public class RoleOperationEntity {
    private int roleOperationId;
    private int operationId;
    private int roleId;
    private OperationEntity operationByOperationId;
    private RoleEntity roleByRoleId;

    @Id
    @Column(name = "RoleOperationId", nullable = false)
    public int getRoleOperationId() {
        return roleOperationId;
    }

    public void setRoleOperationId(int roleOperationId) {
        this.roleOperationId = roleOperationId;
    }

    @Basic
    @Column(name = "OperationId", nullable = false)
    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
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
        RoleOperationEntity that = (RoleOperationEntity) o;
        return roleOperationId == that.roleOperationId &&
                operationId == that.operationId &&
                roleId == that.roleId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(roleOperationId, operationId, roleId);
    }

    @ManyToOne
    @JoinColumn(name = "OperationId", referencedColumnName = "OperationId", nullable = false, insertable = false, updatable = false)
    public OperationEntity getOperationByOperationId() {
        return operationByOperationId;
    }

    public void setOperationByOperationId(OperationEntity operationByOperationId) {
        this.operationByOperationId = operationByOperationId;
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
