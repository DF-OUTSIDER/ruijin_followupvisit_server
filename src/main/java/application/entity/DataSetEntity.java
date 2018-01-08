package application.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "DataSet", schema = "dbo")
public class DataSetEntity {
    private int dataSetId;
    private String hospitalResearchId;
    private String dataSetName;
    private String creatorId;
    private String creator;
    private Timestamp createTime;
    private int total;
    private boolean isValid;
    private HospitalResearchEntity hospitalResearchByHospitalResearchId;
    private Collection<DataSetDetailEntity> dataSetDetailsByDataSetId;

    @Id
    @Column(name = "DataSetId", nullable = false)
    public int getDataSetId() {
        return dataSetId;
    }

    public void setDataSetId(int dataSetId) {
        this.dataSetId = dataSetId;
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
    @Column(name = "DataSetName", nullable = false, length = 100)
    public String getDataSetName() {
        return dataSetName;
    }

    public void setDataSetName(String dataSetName) {
        this.dataSetName = dataSetName;
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
    @Column(name = "IsValid", nullable = false)
    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataSetEntity that = (DataSetEntity) o;
        return dataSetId == that.dataSetId &&
                total == that.total &&
                isValid == that.isValid &&
                Objects.equals(hospitalResearchId, that.hospitalResearchId) &&
                Objects.equals(dataSetName, that.dataSetName) &&
                Objects.equals(creatorId, that.creatorId) &&
                Objects.equals(creator, that.creator) &&
                Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(dataSetId, hospitalResearchId, dataSetName, creatorId, creator, createTime, total, isValid);
    }

    @ManyToOne
    @JoinColumn(name = "HospitalResearchId", referencedColumnName = "HospitalResearchId", nullable = false, insertable = false, updatable = false)
    public HospitalResearchEntity getHospitalResearchByHospitalResearchId() {
        return hospitalResearchByHospitalResearchId;
    }

    public void setHospitalResearchByHospitalResearchId(HospitalResearchEntity hospitalResearchByHospitalResearchId) {
        this.hospitalResearchByHospitalResearchId = hospitalResearchByHospitalResearchId;
    }

    @OneToMany(mappedBy = "dataSetByDataSetId")
    public Collection<DataSetDetailEntity> getDataSetDetailsByDataSetId() {
        return dataSetDetailsByDataSetId;
    }

    public void setDataSetDetailsByDataSetId(Collection<DataSetDetailEntity> dataSetDetailsByDataSetId) {
        this.dataSetDetailsByDataSetId = dataSetDetailsByDataSetId;
    }
}
