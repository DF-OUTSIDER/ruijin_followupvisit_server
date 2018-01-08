package application.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class OrderEntityPK implements Serializable {
    private String orderId;
    private String visitId;

    @Column(name = "OrderId", nullable = false, length = 32)
    @Id
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Column(name = "VisitId", nullable = false, length = 32)
    @Id
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
        OrderEntityPK that = (OrderEntityPK) o;
        return Objects.equals(orderId, that.orderId) &&
                Objects.equals(visitId, that.visitId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderId, visitId);
    }
}
