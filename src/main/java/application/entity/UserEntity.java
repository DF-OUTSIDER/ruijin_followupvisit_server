package application.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "User", schema = "dbo")
public class UserEntity {
    private String userId;
    private String hospitalId;
    private String userAdAccount;
    private String userName;
    private String password;
    private String trueName;
    private String sex;
    private String email;
    private String phone;
    private String tel;
    private String address;
    private String headPhoto;
    private boolean isValid;
    private boolean bValidPhone;
    private Integer smsSendTimesPhone;
    private Date sendSmmDate;
    private boolean bValidEmail;
    private Collection<HisAccountEntity> hisAccountsByUserId;
    private HospitalEntity hospitalByHospitalId;
    private Collection<UserDepartmentEntity> userDepartmentsByUserId;
    private Collection<UserLoginLogEntity> userLoginLogsByUserId;
    private Collection<UserOperationLogEntity> userOperationLogsByUserId;
    private Collection<UserResearchEntity> userResearchesByUserId;
    private Collection<UserRoleEntity> userRolesByUserId;
    private Collection<UserVisitOperationLogEntity> userVisitOperationLogsByUserId;

    @Id
    @Column(name = "UserId", nullable = false, length = 32)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
    @Column(name = "UserADAccount", nullable = true, length = 50)
    public String getUserAdAccount() {
        return userAdAccount;
    }

    public void setUserAdAccount(String userAdAccount) {
        this.userAdAccount = userAdAccount;
    }

    @Basic
    @Column(name = "UserName", nullable = false, length = 50)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "Password", nullable = false, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "TrueName", nullable = false, length = 50)
    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    @Basic
    @Column(name = "Sex", nullable = true, length = 2)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "Email", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "Phone", nullable = true, length = 11)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "Tel", nullable = true, length = 20)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "Address", nullable = true, length = 200)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "HeadPhoto", nullable = true, length = 100)
    public String getHeadPhoto() {
        return headPhoto;
    }

    public void setHeadPhoto(String headPhoto) {
        this.headPhoto = headPhoto;
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
    @Column(name = "BValidPhone", nullable = false)
    public boolean isbValidPhone() {
        return bValidPhone;
    }

    public void setbValidPhone(boolean bValidPhone) {
        this.bValidPhone = bValidPhone;
    }

    @Basic
    @Column(name = "SMSSendTimesPhone", nullable = true)
    public Integer getSmsSendTimesPhone() {
        return smsSendTimesPhone;
    }

    public void setSmsSendTimesPhone(Integer smsSendTimesPhone) {
        this.smsSendTimesPhone = smsSendTimesPhone;
    }

    @Basic
    @Column(name = "SendSMMDate", nullable = true)
    public Date getSendSmmDate() {
        return sendSmmDate;
    }

    public void setSendSmmDate(Date sendSmmDate) {
        this.sendSmmDate = sendSmmDate;
    }

    @Basic
    @Column(name = "BValidEmail", nullable = false)
    public boolean isbValidEmail() {
        return bValidEmail;
    }

    public void setbValidEmail(boolean bValidEmail) {
        this.bValidEmail = bValidEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return isValid == that.isValid &&
                bValidPhone == that.bValidPhone &&
                bValidEmail == that.bValidEmail &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(hospitalId, that.hospitalId) &&
                Objects.equals(userAdAccount, that.userAdAccount) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(password, that.password) &&
                Objects.equals(trueName, that.trueName) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(email, that.email) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(tel, that.tel) &&
                Objects.equals(address, that.address) &&
                Objects.equals(headPhoto, that.headPhoto) &&
                Objects.equals(smsSendTimesPhone, that.smsSendTimesPhone) &&
                Objects.equals(sendSmmDate, that.sendSmmDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, hospitalId, userAdAccount, userName, password, trueName, sex, email, phone, tel, address, headPhoto, isValid, bValidPhone, smsSendTimesPhone, sendSmmDate, bValidEmail);
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<HisAccountEntity> getHisAccountsByUserId() {
        return hisAccountsByUserId;
    }

    public void setHisAccountsByUserId(Collection<HisAccountEntity> hisAccountsByUserId) {
        this.hisAccountsByUserId = hisAccountsByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "HospitalId", referencedColumnName = "HospitalId", nullable = false, insertable = false, updatable = false)
    public HospitalEntity getHospitalByHospitalId() {
        return hospitalByHospitalId;
    }

    public void setHospitalByHospitalId(HospitalEntity hospitalByHospitalId) {
        this.hospitalByHospitalId = hospitalByHospitalId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<UserDepartmentEntity> getUserDepartmentsByUserId() {
        return userDepartmentsByUserId;
    }

    public void setUserDepartmentsByUserId(Collection<UserDepartmentEntity> userDepartmentsByUserId) {
        this.userDepartmentsByUserId = userDepartmentsByUserId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<UserLoginLogEntity> getUserLoginLogsByUserId() {
        return userLoginLogsByUserId;
    }

    public void setUserLoginLogsByUserId(Collection<UserLoginLogEntity> userLoginLogsByUserId) {
        this.userLoginLogsByUserId = userLoginLogsByUserId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<UserOperationLogEntity> getUserOperationLogsByUserId() {
        return userOperationLogsByUserId;
    }

    public void setUserOperationLogsByUserId(Collection<UserOperationLogEntity> userOperationLogsByUserId) {
        this.userOperationLogsByUserId = userOperationLogsByUserId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<UserResearchEntity> getUserResearchesByUserId() {
        return userResearchesByUserId;
    }

    public void setUserResearchesByUserId(Collection<UserResearchEntity> userResearchesByUserId) {
        this.userResearchesByUserId = userResearchesByUserId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<UserRoleEntity> getUserRolesByUserId() {
        return userRolesByUserId;
    }

    public void setUserRolesByUserId(Collection<UserRoleEntity> userRolesByUserId) {
        this.userRolesByUserId = userRolesByUserId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<UserVisitOperationLogEntity> getUserVisitOperationLogsByUserId() {
        return userVisitOperationLogsByUserId;
    }

    public void setUserVisitOperationLogsByUserId(Collection<UserVisitOperationLogEntity> userVisitOperationLogsByUserId) {
        this.userVisitOperationLogsByUserId = userVisitOperationLogsByUserId;
    }
}
