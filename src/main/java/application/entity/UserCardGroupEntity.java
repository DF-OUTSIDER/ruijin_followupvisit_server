package application.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "UserCardGroup", schema = "dbo")
public class UserCardGroupEntity {
    private String userCardHospitalDiseaseId;
    private String userCardId;
    private String groupId;
    private String messageGroupId;
    private String messageGroupName;
    private Collection<MessageEntity> messagesByUserCardHospitalDiseaseId;
    private UserCardEntity userCardByUserCardId;
    private GroupEntity groupByGroupId;
    private Collection<VisitEntity> visitsByUserCardHospitalDiseaseId;

    @Id
    @Column(name = "UserCardHospitalDiseaseId", nullable = false, length = 32)
    public String getUserCardHospitalDiseaseId() {
        return userCardHospitalDiseaseId;
    }

    public void setUserCardHospitalDiseaseId(String userCardHospitalDiseaseId) {
        this.userCardHospitalDiseaseId = userCardHospitalDiseaseId;
    }

    @Basic
    @Column(name = "UserCardId", nullable = false, length = 32)
    public String getUserCardId() {
        return userCardId;
    }

    public void setUserCardId(String userCardId) {
        this.userCardId = userCardId;
    }

    @Basic
    @Column(name = "GroupId", nullable = false, length = 32)
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "MessageGroupId", nullable = false, length = 32)
    public String getMessageGroupId() {
        return messageGroupId;
    }

    public void setMessageGroupId(String messageGroupId) {
        this.messageGroupId = messageGroupId;
    }

    @Basic
    @Column(name = "MessageGroupName", nullable = true, length = 32)
    public String getMessageGroupName() {
        return messageGroupName;
    }

    public void setMessageGroupName(String messageGroupName) {
        this.messageGroupName = messageGroupName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCardGroupEntity that = (UserCardGroupEntity) o;
        return Objects.equals(userCardHospitalDiseaseId, that.userCardHospitalDiseaseId) &&
                Objects.equals(userCardId, that.userCardId) &&
                Objects.equals(groupId, that.groupId) &&
                Objects.equals(messageGroupId, that.messageGroupId) &&
                Objects.equals(messageGroupName, that.messageGroupName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userCardHospitalDiseaseId, userCardId, groupId, messageGroupId, messageGroupName);
    }

    @OneToMany(mappedBy = "userCardGroupByUserCardHospitalDiseaseId")
    public Collection<MessageEntity> getMessagesByUserCardHospitalDiseaseId() {
        return messagesByUserCardHospitalDiseaseId;
    }

    public void setMessagesByUserCardHospitalDiseaseId(Collection<MessageEntity> messagesByUserCardHospitalDiseaseId) {
        this.messagesByUserCardHospitalDiseaseId = messagesByUserCardHospitalDiseaseId;
    }

    @ManyToOne
    @JoinColumn(name = "UserCardId", referencedColumnName = "UserCardId", nullable = false, insertable = false, updatable = false)
    public UserCardEntity getUserCardByUserCardId() {
        return userCardByUserCardId;
    }

    public void setUserCardByUserCardId(UserCardEntity userCardByUserCardId) {
        this.userCardByUserCardId = userCardByUserCardId;
    }

    @ManyToOne
    @JoinColumn(name = "GroupId", referencedColumnName = "GroupId", nullable = false, insertable = false, updatable = false)
    public GroupEntity getGroupByGroupId() {
        return groupByGroupId;
    }

    public void setGroupByGroupId(GroupEntity groupByGroupId) {
        this.groupByGroupId = groupByGroupId;
    }

    @OneToMany(mappedBy = "userCardGroupByUserCardHospitalDiseaseId")
    public Collection<VisitEntity> getVisitsByUserCardHospitalDiseaseId() {
        return visitsByUserCardHospitalDiseaseId;
    }

    public void setVisitsByUserCardHospitalDiseaseId(Collection<VisitEntity> visitsByUserCardHospitalDiseaseId) {
        this.visitsByUserCardHospitalDiseaseId = visitsByUserCardHospitalDiseaseId;
    }
}
