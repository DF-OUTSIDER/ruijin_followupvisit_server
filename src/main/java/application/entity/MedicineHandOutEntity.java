package application.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "MedicineHandOut", schema = "dbo")
public class MedicineHandOutEntity {
    private String medicineHandOutId;
    private int medicineId;
    private String hospitalResearchId;
    private int handOutCount;
    private String handOutOperatorId;
    private Timestamp handOutDatetime;
    private String trackingNumber;
    private String receiveOperatorId;
    private Timestamp receiveDatetime;
    private int handOutStatus;
    private String handOutOperator;
    private String receiveOperator;
    private Collection<MedicineBarcodeEntity> medicineBarcodesByMedicineHandOutId;
    private MedicineEntity medicineByMedicineId;
    private HospitalResearchEntity hospitalResearchByHospitalResearchId;

    @Id
    @Column(name = "MedicineHandOutId", nullable = false, length = 32)
    public String getMedicineHandOutId() {
        return medicineHandOutId;
    }

    public void setMedicineHandOutId(String medicineHandOutId) {
        this.medicineHandOutId = medicineHandOutId;
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
    @Column(name = "HospitalResearchId", nullable = false, length = 32)
    public String getHospitalResearchId() {
        return hospitalResearchId;
    }

    public void setHospitalResearchId(String hospitalResearchId) {
        this.hospitalResearchId = hospitalResearchId;
    }

    @Basic
    @Column(name = "HandOutCount", nullable = false)
    public int getHandOutCount() {
        return handOutCount;
    }

    public void setHandOutCount(int handOutCount) {
        this.handOutCount = handOutCount;
    }

    @Basic
    @Column(name = "HandOutOperatorId", nullable = false, length = 32)
    public String getHandOutOperatorId() {
        return handOutOperatorId;
    }

    public void setHandOutOperatorId(String handOutOperatorId) {
        this.handOutOperatorId = handOutOperatorId;
    }

    @Basic
    @Column(name = "HandOutDatetime", nullable = false)
    public Timestamp getHandOutDatetime() {
        return handOutDatetime;
    }

    public void setHandOutDatetime(Timestamp handOutDatetime) {
        this.handOutDatetime = handOutDatetime;
    }

    @Basic
    @Column(name = "TrackingNumber", nullable = false, length = 50)
    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    @Basic
    @Column(name = "ReceiveOperatorId", nullable = true, length = 32)
    public String getReceiveOperatorId() {
        return receiveOperatorId;
    }

    public void setReceiveOperatorId(String receiveOperatorId) {
        this.receiveOperatorId = receiveOperatorId;
    }

    @Basic
    @Column(name = "ReceiveDatetime", nullable = true)
    public Timestamp getReceiveDatetime() {
        return receiveDatetime;
    }

    public void setReceiveDatetime(Timestamp receiveDatetime) {
        this.receiveDatetime = receiveDatetime;
    }

    @Basic
    @Column(name = "HandOutStatus", nullable = false)
    public int getHandOutStatus() {
        return handOutStatus;
    }

    public void setHandOutStatus(int handOutStatus) {
        this.handOutStatus = handOutStatus;
    }

    @Basic
    @Column(name = "HandOutOperator", nullable = false, length = 50)
    public String getHandOutOperator() {
        return handOutOperator;
    }

    public void setHandOutOperator(String handOutOperator) {
        this.handOutOperator = handOutOperator;
    }

    @Basic
    @Column(name = "ReceiveOperator", nullable = true, length = 50)
    public String getReceiveOperator() {
        return receiveOperator;
    }

    public void setReceiveOperator(String receiveOperator) {
        this.receiveOperator = receiveOperator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicineHandOutEntity that = (MedicineHandOutEntity) o;
        return medicineId == that.medicineId &&
                handOutCount == that.handOutCount &&
                handOutStatus == that.handOutStatus &&
                Objects.equals(medicineHandOutId, that.medicineHandOutId) &&
                Objects.equals(hospitalResearchId, that.hospitalResearchId) &&
                Objects.equals(handOutOperatorId, that.handOutOperatorId) &&
                Objects.equals(handOutDatetime, that.handOutDatetime) &&
                Objects.equals(trackingNumber, that.trackingNumber) &&
                Objects.equals(receiveOperatorId, that.receiveOperatorId) &&
                Objects.equals(receiveDatetime, that.receiveDatetime) &&
                Objects.equals(handOutOperator, that.handOutOperator) &&
                Objects.equals(receiveOperator, that.receiveOperator);
    }

    @Override
    public int hashCode() {

        return Objects.hash(medicineHandOutId, medicineId, hospitalResearchId, handOutCount, handOutOperatorId, handOutDatetime, trackingNumber, receiveOperatorId, receiveDatetime, handOutStatus, handOutOperator, receiveOperator);
    }

    @OneToMany(mappedBy = "medicineHandOutByMedicineHandOutId")
    public Collection<MedicineBarcodeEntity> getMedicineBarcodesByMedicineHandOutId() {
        return medicineBarcodesByMedicineHandOutId;
    }

    public void setMedicineBarcodesByMedicineHandOutId(Collection<MedicineBarcodeEntity> medicineBarcodesByMedicineHandOutId) {
        this.medicineBarcodesByMedicineHandOutId = medicineBarcodesByMedicineHandOutId;
    }

    @ManyToOne
    @JoinColumn(name = "MedicineId", referencedColumnName = "MedicineId", nullable = false, insertable = false, updatable = false)
    public MedicineEntity getMedicineByMedicineId() {
        return medicineByMedicineId;
    }

    public void setMedicineByMedicineId(MedicineEntity medicineByMedicineId) {
        this.medicineByMedicineId = medicineByMedicineId;
    }

    @ManyToOne
    @JoinColumn(name = "HospitalResearchId", referencedColumnName = "HospitalResearchId", nullable = false, insertable = false, updatable = false)
    public HospitalResearchEntity getHospitalResearchByHospitalResearchId() {
        return hospitalResearchByHospitalResearchId;
    }

    public void setHospitalResearchByHospitalResearchId(HospitalResearchEntity hospitalResearchByHospitalResearchId) {
        this.hospitalResearchByHospitalResearchId = hospitalResearchByHospitalResearchId;
    }
}
