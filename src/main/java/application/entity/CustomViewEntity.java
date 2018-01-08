package application.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "CustomView", schema = "dbo")
public class CustomViewEntity {
    private int customViewId;
    private String viewName;
    private String cnName;
    private String description;
    private String category;
    private String timeFilterColumn;
    private String deptFilterColumn;
    private String condition;
    private String creatorId;
    private String creator;
    private Timestamp createTime;
    private Collection<CustomViewColumnEntity> customViewColumnsByCustomViewId;

    @Id
    @Column(name = "CustomViewId", nullable = false)
    public int getCustomViewId() {
        return customViewId;
    }

    public void setCustomViewId(int customViewId) {
        this.customViewId = customViewId;
    }

    @Basic
    @Column(name = "ViewName", nullable = false, length = 255)
    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
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
    @Column(name = "Category", nullable = false, length = 50)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Column(name = "TimeFilterColumn", nullable = false, length = 50)
    public String getTimeFilterColumn() {
        return timeFilterColumn;
    }

    public void setTimeFilterColumn(String timeFilterColumn) {
        this.timeFilterColumn = timeFilterColumn;
    }

    @Basic
    @Column(name = "DeptFilterColumn", nullable = false, length = 50)
    public String getDeptFilterColumn() {
        return deptFilterColumn;
    }

    public void setDeptFilterColumn(String deptFilterColumn) {
        this.deptFilterColumn = deptFilterColumn;
    }

    @Basic
    @Column(name = "Condition", nullable = false, length = 2147483647)
    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Basic
    @Column(name = "CreatorId", nullable = false, length = 32)
    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    @Basic
    @Column(name = "Creator", nullable = false, length = 50)
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Basic
    @Column(name = "CreateTime", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomViewEntity that = (CustomViewEntity) o;
        return customViewId == that.customViewId &&
                Objects.equals(viewName, that.viewName) &&
                Objects.equals(cnName, that.cnName) &&
                Objects.equals(description, that.description) &&
                Objects.equals(category, that.category) &&
                Objects.equals(timeFilterColumn, that.timeFilterColumn) &&
                Objects.equals(deptFilterColumn, that.deptFilterColumn) &&
                Objects.equals(condition, that.condition) &&
                Objects.equals(creatorId, that.creatorId) &&
                Objects.equals(creator, that.creator) &&
                Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(customViewId, viewName, cnName, description, category, timeFilterColumn, deptFilterColumn, condition, creatorId, creator, createTime);
    }

    @OneToMany(mappedBy = "customViewByBaseViewId")
    public Collection<CustomViewColumnEntity> getCustomViewColumnsByCustomViewId() {
        return customViewColumnsByCustomViewId;
    }

    public void setCustomViewColumnsByCustomViewId(Collection<CustomViewColumnEntity> customViewColumnsByCustomViewId) {
        this.customViewColumnsByCustomViewId = customViewColumnsByCustomViewId;
    }
}
