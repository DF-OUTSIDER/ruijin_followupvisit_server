package application.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "District", schema = "dbo")
public class DistrictEntity {
    private int id;
    private String name;
    private Integer parentId;
    private String initial;
    private String initials;
    private String pinyin;
    private String extra;
    private String suffix;
    private String code;
    private String areaCode;
    private BigInteger order;

    @Id
    @Column(name = "id", nullable = false, precision = 0)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 270)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "parent_id", nullable = true, precision = 0)
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "initial", nullable = true, length = 3)
    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    @Basic
    @Column(name = "initials", nullable = true, length = 30)
    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    @Basic
    @Column(name = "pinyin", nullable = true, length = 600)
    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    @Basic
    @Column(name = "extra", nullable = true, length = 60)
    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    @Basic
    @Column(name = "suffix", nullable = true, length = 15)
    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @Basic
    @Column(name = "code", nullable = true, length = 30)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "area_code", nullable = true, length = 30)
    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    @Basic
    @Column(name = "order", nullable = true, precision = 0)
    public BigInteger getOrder() {
        return order;
    }

    public void setOrder(BigInteger order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DistrictEntity that = (DistrictEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(parentId, that.parentId) &&
                Objects.equals(initial, that.initial) &&
                Objects.equals(initials, that.initials) &&
                Objects.equals(pinyin, that.pinyin) &&
                Objects.equals(extra, that.extra) &&
                Objects.equals(suffix, that.suffix) &&
                Objects.equals(code, that.code) &&
                Objects.equals(areaCode, that.areaCode) &&
                Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, parentId, initial, initials, pinyin, extra, suffix, code, areaCode, order);
    }
}
