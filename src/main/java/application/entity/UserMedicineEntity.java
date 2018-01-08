package application.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "UserMedicine", schema = "dbo")
public class UserMedicineEntity {
    private int userMedicineId;
    private int blindId;
    private int medicineBarcodeId;
    private Timestamp dispatchTime;
    private String dispatcher;
    private String visitId;
    private DBlindExEntity dBlindExByBlindId;
    private MedicineBarcodeEntity medicineBarcodeByMedicineBarcodeId;
    private VisitEntity visitByVisitId;

    @Id
    @Column(name = "UserMedicineId", nullable = false)
    public int getUserMedicineId() {
        return userMedicineId;
    }

    public void setUserMedicineId(int userMedicineId) {
        this.userMedicineId = userMedicineId;
    }

    @Basic
    @Column(name = "BlindId", nullable = false)
    public int getBlindId() {
        return blindId;
    }

    public void setBlindId(int blindId) {
        this.blindId = blindId;
    }

    @Basic
    @Column(name = "MedicineBarcodeId", nullable = false)
    public int getMedicineBarcodeId() {
        return medicineBarcodeId;
    }

    public void setMedicineBarcodeId(int medicineBarcodeId) {
        this.medicineBarcodeId = medicineBarcodeId;
    }

    @Basic
    @Column(name = "DispatchTime", nullable = true)
    public Timestamp getDispatchTime() {
        return dispatchTime;
    }

    public void setDispatchTime(Timestamp dispatchTime) {
        this.dispatchTime = dispatchTime;
    }

    @Basic
    @Column(name = "Dispatcher", nullable = true, length = 20)
    public String getDispatcher() {
        return dispatcher;
    }

    public void setDispatcher(String dispatcher) {
        this.dispatcher = dispatcher;
    }

    @Basic
    @Column(name = "VisitId", nullable = false, length = 32)
    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserMedicineEntity that = (UserMedicineEntity) o;
        return userMedicineId == that.userMedicineId &&
                blindId == that.blindId &&
                medicineBarcodeId == that.medicineBarcodeId &&
                Objects.equals(dispatchTime, that.dispatchTime) &&
                Objects.equals(dispatcher, that.dispatcher) &&
                Objects.equals(visitId, that.visitId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userMedicineId, blindId, medicineBarcodeId, dispatchTime, dispatcher, visitId);
    }

    @ManyToOne
    @JoinColumn(name = "BlindId", referencedColumnName = "BlindId", nullable = false, insertable = false, updatable = false)
    public DBlindExEntity getdBlindExByBlindId() {
        return dBlindExByBlindId;
    }

    public void setdBlindExByBlindId(DBlindExEntity dBlindExByBlindId) {
        this.dBlindExByBlindId = dBlindExByBlindId;
    }

    @ManyToOne
    @JoinColumn(name = "MedicineBarcodeId", referencedColumnName = "MedicineBarcodeId", nullable = false, insertable = false, updatable = false)
    public MedicineBarcodeEntity getMedicineBarcodeByMedicineBarcodeId() {
        return medicineBarcodeByMedicineBarcodeId;
    }

    public void setMedicineBarcodeByMedicineBarcodeId(MedicineBarcodeEntity medicineBarcodeByMedicineBarcodeId) {
        this.medicineBarcodeByMedicineBarcodeId = medicineBarcodeByMedicineBarcodeId;
    }

    @ManyToOne
    @JoinColumn(name = "VisitId", referencedColumnName = "VisitId", nullable = false, insertable = false, updatable = false)
    public VisitEntity getVisitByVisitId() {
        return visitByVisitId;
    }

    public void setVisitByVisitId(VisitEntity visitByVisitId) {
        this.visitByVisitId = visitByVisitId;
    }
}
