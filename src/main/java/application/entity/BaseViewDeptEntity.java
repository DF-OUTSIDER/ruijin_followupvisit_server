package application.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "BaseViewDept", schema = "dbo")
public class BaseViewDeptEntity {
    private String baseViewDeptId;
    private String deptId;
    private int viewId;
    private DepartmentEntity departmentByDeptId;
    private BaseViewEntity baseViewByViewId;

    @Id
    @Column(name = "BaseViewDeptId", nullable = false, length = 32)
    public String getBaseViewDeptId() {
        return baseViewDeptId;
    }

    public void setBaseViewDeptId(String baseViewDeptId) {
        this.baseViewDeptId = baseViewDeptId;
    }

    @Basic
    @Column(name = "DeptId", nullable = false, length = 32)
    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    @Basic
    @Column(name = "ViewId", nullable = false)
    public int getViewId() {
        return viewId;
    }

    public void setViewId(int viewId) {
        this.viewId = viewId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseViewDeptEntity that = (BaseViewDeptEntity) o;
        return viewId == that.viewId &&
                Objects.equals(baseViewDeptId, that.baseViewDeptId) &&
                Objects.equals(deptId, that.deptId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(baseViewDeptId, deptId, viewId);
    }

    @ManyToOne
    @JoinColumn(name = "DeptId", referencedColumnName = "DeptId", nullable = false, insertable = false, updatable = false)
    public DepartmentEntity getDepartmentByDeptId() {
        return departmentByDeptId;
    }

    public void setDepartmentByDeptId(DepartmentEntity departmentByDeptId) {
        this.departmentByDeptId = departmentByDeptId;
    }

    @ManyToOne
    @JoinColumn(name = "ViewId", referencedColumnName = "ViewId", nullable = false, insertable = false, updatable = false)
    public BaseViewEntity getBaseViewByViewId() {
        return baseViewByViewId;
    }

    public void setBaseViewByViewId(BaseViewEntity baseViewByViewId) {
        this.baseViewByViewId = baseViewByViewId;
    }
}
