package application.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Group", schema = "dbo")
public class GroupEntity {
    private String groupId;
    private String hospitalResearchId;
    private String groupName;
    private String description;
    private String creatorId;
    private String creator;
    private Timestamp createTime;
    private int total;
    private boolean isDel;
    private int groupType;
    private HospitalResearchEntity hospitalResearchByHospitalResearchId;
    private Collection<UserCardGroupEntity> userCardGroupsByGroupId;

    @Id
    @Column(name = "GroupId", nullable = false, length = 32)
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "HospitalResearchId", nullable = false, length = 32)
    public String getHospitalResearchId() {
        return hospitalResearchId;
    }

    public void setHospitalResearchId(String hospitalResearchId) {
        this.hospitalResearchId = hospitalResearchId;
    }

    @Basic
    @Column(name = "GroupName", nullable = false, length = 50)
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Basic
    @Column(name = "Description", nullable = true, length = 200)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "CreatorId", nullable = false, length = 32)
    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    @Basic
    @Column(name = "Creator", nullable = false, length = 50)
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Basic
    @Column(name = "CreateTime", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "Total", nullable = false)
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
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
    @Column(name = "GroupType", nullable = false)
    public int getGroupType() {
        return groupType;
    }

    public void setGroupType(int groupType) {
        this.groupType = groupType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupEntity that = (GroupEntity) o;
        return total == that.total &&
                isDel == that.isDel &&
                groupType == that.groupType &&
                Objects.equals(groupId, that.groupId) &&
                Objects.equals(hospitalResearchId, that.hospitalResearchId) &&
                Objects.equals(groupName, that.groupName) &&
                Objects.equals(description, that.description) &&
                Objects.equals(creatorId, that.creatorId) &&
                Objects.equals(creator, that.creator) &&
                Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(groupId, hospitalResearchId, groupName, description, creatorId, creator, createTime, total, isDel, groupType);
    }

    @ManyToOne
    @JoinColumn(name = "HospitalResearchId", referencedColumnName = "HospitalResearchId", nullable = false, insertable = false, updatable = false)
    public HospitalResearchEntity getHospitalResearchByHospitalResearchId() {
        return hospitalResearchByHospitalResearchId;
    }

    public void setHospitalResearchByHospitalResearchId(HospitalResearchEntity hospitalResearchByHospitalResearchId) {
        this.hospitalResearchByHospitalResearchId = hospitalResearchByHospitalResearchId;
    }

    @OneToMany(mappedBy = "groupByGroupId")
    public Collection<UserCardGroupEntity> getUserCardGroupsByGroupId() {
        return userCardGroupsByGroupId;
    }

    public void setUserCardGroupsByGroupId(Collection<UserCardGroupEntity> userCardGroupsByGroupId) {
        this.userCardGroupsByGroupId = userCardGroupsByGroupId;
    }
}
