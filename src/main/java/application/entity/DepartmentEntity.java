package application.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Department", schema = "dbo")
public class DepartmentEntity {
    private String deptId;
    private String originalDeptId;
    private String hospitalId;
    private String deptName;
    private String pinYinAbbr;
    private Collection<BaseViewDeptEntity> baseViewDeptsByDeptId;
    private HospitalEntity hospitalByHospitalId;
    private Collection<UserDepartmentEntity> userDepartmentsByDeptId;

    @Id
    @Column(name = "DeptId", nullable = false, length = 32)
    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    @Basic
    @Column(name = "OriginalDeptId", nullable = false, length = 50)
    public String getOriginalDeptId() {
        return originalDeptId;
    }

    public void setOriginalDeptId(String originalDeptId) {
        this.originalDeptId = originalDeptId;
    }

    @Basic
    @Column(name = "HospitalId", nullable = false, length = 32)
    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    @Basic
    @Column(name = "DeptName", nullable = false, length = 50)
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Basic
    @Column(name = "PinYinAbbr", nullable = true, length = 50)
    public String getPinYinAbbr() {
        return pinYinAbbr;
    }

    public void setPinYinAbbr(String pinYinAbbr) {
        this.pinYinAbbr = pinYinAbbr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentEntity that = (DepartmentEntity) o;
        return Objects.equals(deptId, that.deptId) &&
                Objects.equals(originalDeptId, that.originalDeptId) &&
                Objects.equals(hospitalId, that.hospitalId) &&
                Objects.equals(deptName, that.deptName) &&
                Objects.equals(pinYinAbbr, that.pinYinAbbr);
    }

    @Override
    public int hashCode() {

        return Objects.hash(deptId, originalDeptId, hospitalId, deptName, pinYinAbbr);
    }

    @OneToMany(mappedBy = "departmentByDeptId")
    public Collection<BaseViewDeptEntity> getBaseViewDeptsByDeptId() {
        return baseViewDeptsByDeptId;
    }

    public void setBaseViewDeptsByDeptId(Collection<BaseViewDeptEntity> baseViewDeptsByDeptId) {
        this.baseViewDeptsByDeptId = baseViewDeptsByDeptId;
    }

    @ManyToOne
    @JoinColumn(name = "HospitalId", referencedColumnName = "HospitalId", nullable = false, updatable = false, insertable = false)
    public HospitalEntity getHospitalByHospitalId() {
        return hospitalByHospitalId;
    }

    public void setHospitalByHospitalId(HospitalEntity hospitalByHospitalId) {
        this.hospitalByHospitalId = hospitalByHospitalId;
    }

    @OneToMany(mappedBy = "departmentByDeptId")
    public Collection<UserDepartmentEntity> getUserDepartmentsByDeptId() {
        return userDepartmentsByDeptId;
    }

    public void setUserDepartmentsByDeptId(Collection<UserDepartmentEntity> userDepartmentsByDeptId) {
        this.userDepartmentsByDeptId = userDepartmentsByDeptId;
    }
}
