package application.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "MedicineBarcode", schema = "dbo")
public class MedicineBarcodeEntity {
    private int medicineBarcodeId;
    private String barcode;
    private Boolean isTrue;
    private int status;
    private String medicineHandOutId;
    private MedicineHandOutEntity medicineHandOutByMedicineHandOutId;
    private Collection<UserMedicineEntity> userMedicinesByMedicineBarcodeId;

    @Id
    @Column(name = "MedicineBarcodeId", nullable = false)
    public int getMedicineBarcodeId() {
        return medicineBarcodeId;
    }

    public void setMedicineBarcodeId(int medicineBarcodeId) {
        this.medicineBarcodeId = medicineBarcodeId;
    }

    @Basic
    @Column(name = "Barcode", nullable = true, length = 20)
    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @Basic
    @Column(name = "IsTrue", nullable = true)
    public Boolean getTrue() {
        return isTrue;
    }

    public void setTrue(Boolean aTrue) {
        isTrue = aTrue;
    }

    @Basic
    @Column(name = "Status", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "MedicineHandOutId", nullable = false, length = 32)
    public String getMedicineHandOutId() {
        return medicineHandOutId;
    }

    public void setMedicineHandOutId(String medicineHandOutId) {
        this.medicineHandOutId = medicineHandOutId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicineBarcodeEntity that = (MedicineBarcodeEntity) o;
        return medicineBarcodeId == that.medicineBarcodeId &&
                status == that.status &&
                Objects.equals(barcode, that.barcode) &&
                Objects.equals(isTrue, that.isTrue) &&
                Objects.equals(medicineHandOutId, that.medicineHandOutId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(medicineBarcodeId, barcode, isTrue, status, medicineHandOutId);
    }

    @ManyToOne
    @JoinColumn(name = "MedicineHandOutId", referencedColumnName = "MedicineHandOutId", nullable = false, insertable = false, updatable = false)
    public MedicineHandOutEntity getMedicineHandOutByMedicineHandOutId() {
        return medicineHandOutByMedicineHandOutId;
    }

    public void setMedicineHandOutByMedicineHandOutId(MedicineHandOutEntity medicineHandOutByMedicineHandOutId) {
        this.medicineHandOutByMedicineHandOutId = medicineHandOutByMedicineHandOutId;
    }

    @OneToMany(mappedBy = "medicineBarcodeByMedicineBarcodeId")
    public Collection<UserMedicineEntity> getUserMedicinesByMedicineBarcodeId() {
        return userMedicinesByMedicineBarcodeId;
    }

    public void setUserMedicinesByMedicineBarcodeId(Collection<UserMedicineEntity> userMedicinesByMedicineBarcodeId) {
        this.userMedicinesByMedicineBarcodeId = userMedicinesByMedicineBarcodeId;
    }
}
