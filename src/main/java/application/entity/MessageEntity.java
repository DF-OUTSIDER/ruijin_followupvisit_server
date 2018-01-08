package application.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Message", schema = "dbo")
public class MessageEntity {
    private String messageId;
    private String userCardHospitalDiseaseId;
    private String content;
    private Timestamp updDate;
    private String type;
    private boolean isDrawBack;
    private String senderId;
    private boolean isDoctor;
    private boolean isDel;
    private UserCardGroupEntity userCardGroupByUserCardHospitalDiseaseId;

    @Id
    @Column(name = "MessageId", nullable = false, length = 32)
    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    @Basic
    @Column(name = "UserCardHospitalDiseaseId", nullable = true, length = 32)
    public String getUserCardHospitalDiseaseId() {
        return userCardHospitalDiseaseId;
    }

    public void setUserCardHospitalDiseaseId(String userCardHospitalDiseaseId) {
        this.userCardHospitalDiseaseId = userCardHospitalDiseaseId;
    }

    @Basic
    @Column(name = "Content", nullable = true, length = 2147483647)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
    @Column(name = "Type", nullable = false, length = 20)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "IsDrawBack", nullable = false)
    public boolean isDrawBack() {
        return isDrawBack;
    }

    public void setDrawBack(boolean drawBack) {
        isDrawBack = drawBack;
    }

    @Basic
    @Column(name = "SenderId", nullable = false, length = 32)
    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    @Basic
    @Column(name = "IsDoctor", nullable = false)
    public boolean isDoctor() {
        return isDoctor;
    }

    public void setDoctor(boolean doctor) {
        isDoctor = doctor;
    }

    @Basic
    @Column(name = "IsDel", nullable = false)
    public boolean isDel() {
        return isDel;
    }

    public void setDel(boolean del) {
        isDel = del;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageEntity that = (MessageEntity) o;
        return isDrawBack == that.isDrawBack &&
                isDoctor == that.isDoctor &&
                isDel == that.isDel &&
                Objects.equals(messageId, that.messageId) &&
                Objects.equals(userCardHospitalDiseaseId, that.userCardHospitalDiseaseId) &&
                Objects.equals(content, that.content) &&
                Objects.equals(updDate, that.updDate) &&
                Objects.equals(type, that.type) &&
                Objects.equals(senderId, that.senderId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(messageId, userCardHospitalDiseaseId, content, updDate, type, isDrawBack, senderId, isDoctor, isDel);
    }

    @ManyToOne
    @JoinColumn(name = "UserCardHospitalDiseaseId", referencedColumnName = "UserCardHospitalDiseaseId", insertable = false, updatable = false)
    public UserCardGroupEntity getUserCardGroupByUserCardHospitalDiseaseId() {
        return userCardGroupByUserCardHospitalDiseaseId;
    }

    public void setUserCardGroupByUserCardHospitalDiseaseId(UserCardGroupEntity userCardGroupByUserCardHospitalDiseaseId) {
        this.userCardGroupByUserCardHospitalDiseaseId = userCardGroupByUserCardHospitalDiseaseId;
    }
}
