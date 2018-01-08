package application.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CustomViewColumn", schema = "dbo")
public class CustomViewColumnEntity {
    private int columnId;
    private int baseViewId;
    private String columnName;
    private String type;
    private int length;
    private String cnName;
    private String description;
    private boolean isDisplay;
    private boolean isIdx;
    private int sort;
    private CustomViewEntity customViewByBaseViewId;

    @Id
    @Column(name = "ColumnId", nullable = false)
    public int getColumnId() {
        return columnId;
    }

    public void setColumnId(int columnId) {
        this.columnId = columnId;
    }

    @Basic
    @Column(name = "BaseViewId", nullable = false)
    public int getBaseViewId() {
        return baseViewId;
    }

    public void setBaseViewId(int baseViewId) {
        this.baseViewId = baseViewId;
    }

    @Basic
    @Column(name = "ColumnName", nullable = false, length = 255)
    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    @Basic
    @Column(name = "Type", nullable = false, length = 255)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "Length", nullable = false)
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Basic
    @Column(name = "CNName", nullable = false, length = 100)
    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    @Basic
    @Column(name = "Description", nullable = true, length = 500)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "IsDisplay", nullable = false)
    public boolean isDisplay() {
        return isDisplay;
    }

    public void setDisplay(boolean display) {
        isDisplay = display;
    }

    @Basic
    @Column(name = "IsIDX", nullable = false)
    public boolean isIdx() {
        return isIdx;
    }

    public void setIdx(boolean idx) {
        isIdx = idx;
    }

    @Basic
    @Column(name = "Sort", nullable = false)
    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomViewColumnEntity that = (CustomViewColumnEntity) o;
        return columnId == that.columnId &&
                baseViewId == that.baseViewId &&
                length == that.length &&
                isDisplay == that.isDisplay &&
                isIdx == that.isIdx &&
                sort == that.sort &&
                Objects.equals(columnName, that.columnName) &&
                Objects.equals(type, that.type) &&
                Objects.equals(cnName, that.cnName) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(columnId, baseViewId, columnName, type, length, cnName, description, isDisplay, isIdx, sort);
    }

    @ManyToOne
    @JoinColumn(name = "BaseViewId", referencedColumnName = "CustomViewId", nullable = false, insertable = false, updatable = false)
    public CustomViewEntity getCustomViewByBaseViewId() {
        return customViewByBaseViewId;
    }

    public void setCustomViewByBaseViewId(CustomViewEntity customViewByBaseViewId) {
        this.customViewByBaseViewId = customViewByBaseViewId;
    }
}
