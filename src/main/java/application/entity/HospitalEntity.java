package application.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Hospital", schema = "dbo")
public class HospitalEntity {
    private String hospitalId;
    private String hospitalName;
    private String address;
    private String level;
    private String tel;
    private boolean isDel;
    private boolean haveDataCenter;
    private String hospitalCode;
    private Collection<DepartmentEntity> departmentsByHospitalId;
    private Collection<HospitalResearchEntity> hospitalResearchesByHospitalId;
    private Collection<UserEntity> usersByHospitalId;

    @Id
    @Column(name = "HospitalId", nullable = false, length = 32)
    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    @Basic
    @Column(name = "HospitalName", nullable = false, length = 50)
    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    @Basic
    @Column(name = "Address", nullable = true, length = 100)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "Level", nullable = true, length = 50)
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Basic
    @Column(name = "Tel", nullable = true, length = 11)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "IsDel", nullable = false)
    public boolean isDel() {
        return isDel;
    }

    public void setDel(boolean del) {
        isDel = del;
    }

    @Basic
    @Column(name = "HaveDataCenter", nullable = false)
    public boolean isHaveDataCenter() {
        return haveDataCenter;
    }

    public void setHaveDataCenter(boolean haveDataCenter) {
        this.haveDataCenter = haveDataCenter;
    }

    @Basic
    @Column(name = "HospitalCode", nullable = false, length = 4)
    public String getHospitalCode() {
        return hospitalCode;
    }

    public void setHospitalCode(String hospitalCode) {
        this.hospitalCode = hospitalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HospitalEntity that = (HospitalEntity) o;
        return isDel == that.isDel &&
                haveDataCenter == that.haveDataCenter &&
                Objects.equals(hospitalId, that.hospitalId) &&
                Objects.equals(hospitalName, that.hospitalName) &&
                Objects.equals(address, that.address) &&
                Objects.equals(level, that.level) &&
                Objects.equals(tel, that.tel) &&
                Objects.equals(hospitalCode, that.hospitalCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(hospitalId, hospitalName, address, level, tel, isDel, haveDataCenter, hospitalCode);
    }

    @OneToMany(mappedBy = "hospitalByHospitalId")
    public Collection<DepartmentEntity> getDepartmentsByHospitalId() {
        return departmentsByHospitalId;
    }

    public void setDepartmentsByHospitalId(Collection<DepartmentEntity> departmentsByHospitalId) {
        this.departmentsByHospitalId = departmentsByHospitalId;
    }

    @OneToMany(mappedBy = "hospitalByHospitalId")
    public Collection<HospitalResearchEntity> getHospitalResearchesByHospitalId() {
        return hospitalResearchesByHospitalId;
    }

    public void setHospitalResearchesByHospitalId(Collection<HospitalResearchEntity> hospitalResearchesByHospitalId) {
        this.hospitalResearchesByHospitalId = hospitalResearchesByHospitalId;
    }

    @OneToMany(mappedBy = "hospitalByHospitalId")
    public Collection<UserEntity> getUsersByHospitalId() {
        return usersByHospitalId;
    }

    public void setUsersByHospitalId(Collection<UserEntity> usersByHospitalId) {
        this.usersByHospitalId = usersByHospitalId;
    }
}
