package application.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Medicine", schema = "dbo")
public class MedicineEntity {
    private int medicineId;
    private String medicineName;
    private String dose;
    private String unit;
    private Integer qty;
    private String manufacturer;
    private String researchId;
    private ResearchEntity researchByResearchId;
    private Collection<MedicineBarcodeSeedEntity> medicineBarcodeSeedsByMedicineId;
    private Collection<MedicineHandOutEntity> medicineHandOutsByMedicineId;

    @Id
    @Column(name = "MedicineId", nullable = false)
    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    @Basic
    @Column(name = "MedicineName", nullable = true, length = 50)
    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    @Basic
    @Column(name = "Dose", nullable = true, length = 20)
    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    @Basic
    @Column(name = "Unit", nullable = true, length = 20)
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "Qty", nullable = true)
    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @Basic
    @Column(name = "Manufacturer", nullable = true, length = 50)
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Basic
    @Column(name = "ResearchId", nullable = false, length = 32)
    public String getResearchId() {
        return researchId;
    }

    public void setResearchId(String researchId) {
        this.researchId = researchId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicineEntity that = (MedicineEntity) o;
        return medicineId == that.medicineId &&
                Objects.equals(medicineName, that.medicineName) &&
                Objects.equals(dose, that.dose) &&
                Objects.equals(unit, that.unit) &&
                Objects.equals(qty, that.qty) &&
                Objects.equals(manufacturer, that.manufacturer) &&
                Objects.equals(researchId, that.researchId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(medicineId, medicineName, dose, unit, qty, manufacturer, researchId);
    }

    @ManyToOne
    @JoinColumn(name = "ResearchId", referencedColumnName = "ResearchId", nullable = false, insertable = false, updatable = false)
    public ResearchEntity getResearchByResearchId() {
        return researchByResearchId;
    }

    public void setResearchByResearchId(ResearchEntity researchByResearchId) {
        this.researchByResearchId = researchByResearchId;
    }

    @OneToMany(mappedBy = "medicineByMedicineId")
    public Collection<MedicineBarcodeSeedEntity> getMedicineBarcodeSeedsByMedicineId() {
        return medicineBarcodeSeedsByMedicineId;
    }

    public void setMedicineBarcodeSeedsByMedicineId(Collection<MedicineBarcodeSeedEntity> medicineBarcodeSeedsByMedicineId) {
        this.medicineBarcodeSeedsByMedicineId = medicineBarcodeSeedsByMedicineId;
    }

    @OneToMany(mappedBy = "medicineByMedicineId")
    public Collection<MedicineHandOutEntity> getMedicineHandOutsByMedicineId() {
        return medicineHandOutsByMedicineId;
    }

    public void setMedicineHandOutsByMedicineId(Collection<MedicineHandOutEntity> medicineHandOutsByMedicineId) {
        this.medicineHandOutsByMedicineId = medicineHandOutsByMedicineId;
    }
}
