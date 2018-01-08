package application.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "APPUser", schema = "dbo")
public class AppUserEntity {
    private String userId;
    private String userNo;
    private String userName;
    private String sex;
    private String idCardNo;
    private String headPhoto;
    private String idCardImg;
    private String phone;
    private String email;
    private String examine;
    private String address;
    private String pwd;
    private boolean isValid;
    private Timestamp updDate;
    private String postCode;
    private String reason;
    private boolean isNewPatientMessage;
    private boolean isNewDoctorMessage;
    private Collection<DBlindExEntity> dBlindicesByUserId;
    private Collection<PhotoEntity> photosByUserId;
    private TokenEntity tokenByUserId;
    private Collection<UserCardEntity> userCardsByUserId;
    private Collection<UserDblindConditionAnswerEntity> userDblindConditionAnswersByUserId;

    @Id
    @Column(name = "UserId", nullable = false, length = 32)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "UserNo", nullable = true, length = 150)
    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    @Basic
    @Column(name = "UserName", nullable = false, length = 150)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "Sex", nullable = false, length = 2)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "IdCardNo", nullable = false, length = 120)
    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    @Basic
    @Column(name = "HeadPhoto", nullable = true, length = 2147483647)
    public String getHeadPhoto() {
        return headPhoto;
    }

    public void setHeadPhoto(String headPhoto) {
        this.headPhoto = headPhoto;
    }

    @Basic
    @Column(name = "IdCardImg", nullable = true, length = 2147483647)
    public String getIdCardImg() {
        return idCardImg;
    }

    public void setIdCardImg(String idCardImg) {
        this.idCardImg = idCardImg;
    }

    @Basic
    @Column(name = "Phone", nullable = false, length = 50)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
    @Column(name = "Examine", nullable = true, length = 20)
    public String getExamine() {
        return examine;
    }

    public void setExamine(String examine) {
        this.examine = examine;
    }

    @Basic
    @Column(name = "Address", nullable = true, length = 50)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "Pwd", nullable = true, length = 50)
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
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
    @Column(name = "UpdDate", nullable = false)
    public Timestamp getUpdDate() {
        return updDate;
    }

    public void setUpdDate(Timestamp updDate) {
        this.updDate = updDate;
    }

    @Basic
    @Column(name = "PostCode", nullable = true, length = 10)
    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Basic
    @Column(name = "Reason", nullable = true, length = 200)
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Basic
    @Column(name = "IsNewPatientMessage", nullable = false)
    public boolean isNewPatientMessage() {
        return isNewPatientMessage;
    }

    public void setNewPatientMessage(boolean newPatientMessage) {
        isNewPatientMessage = newPatientMessage;
    }

    @Basic
    @Column(name = "IsNewDoctorMessage", nullable = false)
    public boolean isNewDoctorMessage() {
        return isNewDoctorMessage;
    }

    public void setNewDoctorMessage(boolean newDoctorMessage) {
        isNewDoctorMessage = newDoctorMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUserEntity that = (AppUserEntity) o;
        return isValid == that.isValid &&
                isNewPatientMessage == that.isNewPatientMessage &&
                isNewDoctorMessage == that.isNewDoctorMessage &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(userNo, that.userNo) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(idCardNo, that.idCardNo) &&
                Objects.equals(headPhoto, that.headPhoto) &&
                Objects.equals(idCardImg, that.idCardImg) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(email, that.email) &&
                Objects.equals(examine, that.examine) &&
                Objects.equals(address, that.address) &&
                Objects.equals(pwd, that.pwd) &&
                Objects.equals(updDate, that.updDate) &&
                Objects.equals(postCode, that.postCode) &&
                Objects.equals(reason, that.reason);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, userNo, userName, sex, idCardNo, headPhoto, idCardImg, phone, email, examine, address, pwd, isValid, updDate, postCode, reason, isNewPatientMessage, isNewDoctorMessage);
    }

    @OneToMany(mappedBy = "appUserByUserId")
    public Collection<DBlindExEntity> getdBlindicesByUserId() {
        return dBlindicesByUserId;
    }

    public void setdBlindicesByUserId(Collection<DBlindExEntity> dBlindicesByUserId) {
        this.dBlindicesByUserId = dBlindicesByUserId;
    }

    @OneToMany(mappedBy = "appUserByUserId")
    public Collection<PhotoEntity> getPhotosByUserId() {
        return photosByUserId;
    }

    public void setPhotosByUserId(Collection<PhotoEntity> photosByUserId) {
        this.photosByUserId = photosByUserId;
    }

    @OneToOne(mappedBy = "appUserByUserId")
    public TokenEntity getTokenByUserId() {
        return tokenByUserId;
    }

    public void setTokenByUserId(TokenEntity tokenByUserId) {
        this.tokenByUserId = tokenByUserId;
    }

    @OneToMany(mappedBy = "appUserByUserId")
    public Collection<UserCardEntity> getUserCardsByUserId() {
        return userCardsByUserId;
    }

    public void setUserCardsByUserId(Collection<UserCardEntity> userCardsByUserId) {
        this.userCardsByUserId = userCardsByUserId;
    }

    @OneToMany(mappedBy = "appUserByUserId")
    public Collection<UserDblindConditionAnswerEntity> getUserDblindConditionAnswersByUserId() {
        return userDblindConditionAnswersByUserId;
    }

    public void setUserDblindConditionAnswersByUserId(Collection<UserDblindConditionAnswerEntity> userDblindConditionAnswersByUserId) {
        this.userDblindConditionAnswersByUserId = userDblindConditionAnswersByUserId;
    }
}
