package application.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "DataSetDetail", schema = "dbo")
public class DataSetDetailEntity {
    private int id;
    private Integer dataSetId;
    private String mpix;
    private String medicineCard;
    private String name;
    private String sex;
    private Timestamp birthDate;
    private DataSetEntity dataSetByDataSetId;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "DataSetId", nullable = true)
    public Integer getDataSetId() {
        return dataSetId;
    }

    public void setDataSetId(Integer dataSetId) {
        this.dataSetId = dataSetId;
    }

    @Basic
    @Column(name = "MPIX", nullable = true, length = 50)
    public String getMpix() {
        return mpix;
    }

    public void setMpix(String mpix) {
        this.mpix = mpix;
    }

    @Basic
    @Column(name = "MedicineCard", nullable = false, length = 500)
    public String getMedicineCard() {
        return medicineCard;
    }

    public void setMedicineCard(String medicineCard) {
        this.medicineCard = medicineCard;
    }

    @Basic
    @Column(name = "Name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "BirthDate", nullable = true)
    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataSetDetailEntity that = (DataSetDetailEntity) o;
        return id == that.id &&
                Objects.equals(dataSetId, that.dataSetId) &&
                Objects.equals(mpix, that.mpix) &&
                Objects.equals(medicineCard, that.medicineCard) &&
                Objects.equals(name, that.name) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(birthDate, that.birthDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, dataSetId, mpix, medicineCard, name, sex, birthDate);
    }

    @ManyToOne
    @JoinColumn(name = "DataSetId", referencedColumnName = "DataSetId", insertable = false, updatable = false)
    public DataSetEntity getDataSetByDataSetId() {
        return dataSetByDataSetId;
    }

    public void setDataSetByDataSetId(DataSetEntity dataSetByDataSetId) {
        this.dataSetByDataSetId = dataSetByDataSetId;
    }
}
