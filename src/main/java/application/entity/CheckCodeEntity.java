package application.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "CheckCode", schema = "dbo")
public class CheckCodeEntity {
    private String checkCodeId;
    private String phone;
    private String code;
    private Timestamp sendDate;
    private Timestamp updDate;
    private int count;

    @Id
    @Column(name = "CheckCodeId", nullable = false, length = 32)
    public String getCheckCodeId() {
        return checkCodeId;
    }

    public void setCheckCodeId(String checkCodeId) {
        this.checkCodeId = checkCodeId;
    }

    @Basic
    @Column(name = "Phone", nullable = false, length = 11)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "Code", nullable = false, length = 6)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "SendDate", nullable = false)
    public Timestamp getSendDate() {
        return sendDate;
    }

    public void setSendDate(Timestamp sendDate) {
        this.sendDate = sendDate;
    }

    @Basic
    @Column(name = "UpdDate", nullable = false)
    public Timestamp getUpdDate() {
        return updDate;
    }

    public void setUpdDate(Timestamp updDate) {
        this.updDate = updDate;
    }

    @Basic
    @Column(name = "Count", nullable = false)
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckCodeEntity that = (CheckCodeEntity) o;
        return count == that.count &&
                Objects.equals(checkCodeId, that.checkCodeId) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(code, that.code) &&
                Objects.equals(sendDate, that.sendDate) &&
                Objects.equals(updDate, that.updDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(checkCodeId, phone, code, sendDate, updDate, count);
    }
}
