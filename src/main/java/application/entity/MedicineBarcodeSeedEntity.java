package application.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "MedicineBarcodeSeed", schema = "dbo")
public class MedicineBarcodeSeedEntity {
    private int seedId;
    private String hospitalResearchId;
    private int medicineId;
    private int nextNumber;
    private HospitalResearchEntity hospitalResearchByHospitalResearchId;
    private MedicineEntity medicineByMedicineId;

    @Id
    @Column(name = "SeedId", nullable = false)
    public int getSeedId() {
        return seedId;
    }

    public void setSeedId(int seedId) {
        this.seedId = seedId;
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
    @Column(name = "MedicineId", nullable = false)
    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    @Basic
    @Column(name = "NextNumber", nullable = false)
    public int getNextNumber() {
        return nextNumber;
    }

    public void setNextNumber(int nextNumber) {
        this.nextNumber = nextNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicineBarcodeSeedEntity that = (MedicineBarcodeSeedEntity) o;
        return seedId == that.seedId &&
                medicineId == that.medicineId &&
                nextNumber == that.nextNumber &&
                Objects.equals(hospitalResearchId, that.hospitalResearchId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(seedId, hospitalResearchId, medicineId, nextNumber);
    }

    @ManyToOne
    @JoinColumn(name = "HospitalResearchId", referencedColumnName = "HospitalResearchId", nullable = false, insertable = false, updatable = false)
    public HospitalResearchEntity getHospitalResearchByHospitalResearchId() {
        return hospitalResearchByHospitalResearchId;
    }

    public void setHospitalResearchByHospitalResearchId(HospitalResearchEntity hospitalResearchByHospitalResearchId) {
        this.hospitalResearchByHospitalResearchId = hospitalResearchByHospitalResearchId;
    }

    @ManyToOne
    @JoinColumn(name = "MedicineId", referencedColumnName = "MedicineId", nullable = false, insertable = false, updatable = false)
    public MedicineEntity getMedicineByMedicineId() {
        return medicineByMedicineId;
    }

    public void setMedicineByMedicineId(MedicineEntity medicineByMedicineId) {
        this.medicineByMedicineId = medicineByMedicineId;
    }
}
