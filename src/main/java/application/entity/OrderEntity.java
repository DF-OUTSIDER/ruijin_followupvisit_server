package application.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Order", schema = "dbo")
@IdClass(OrderEntityPK.class)
public class OrderEntity {
    private String orderId;
    private String visitId;
    private Timestamp ordertDate;
    private String orderStatus;
    private VisitEntity visitByVisitId;

    @Id
    @Column(name = "OrderId", nullable = false, length = 32)
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Id
    @Column(name = "VisitId", nullable = false, length = 32)
    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    @Basic
    @Column(name = "OrdertDate", nullable = false)
    public Timestamp getOrdertDate() {
        return ordertDate;
    }

    public void setOrdertDate(Timestamp ordertDate) {
        this.ordertDate = ordertDate;
    }

    @Basic
    @Column(name = "OrderStatus", nullable = false, length = 20)
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return Objects.equals(orderId, that.orderId) &&
                Objects.equals(visitId, that.visitId) &&
                Objects.equals(ordertDate, that.ordertDate) &&
                Objects.equals(orderStatus, that.orderStatus);
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderId, visitId, ordertDate, orderStatus);
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
