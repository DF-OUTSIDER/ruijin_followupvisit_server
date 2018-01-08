package application.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "BaseView", schema = "dbo")
public class BaseViewEntity {
    private int viewId;
    private String viewName;
    private String cnName;
    private String description;
    private String timeFilterColumn;
    private String deptFilterColumn;
    private String category;
    private String creatorId;
    private String creator;
    private Timestamp createTime;
    private BigDecimal sort;
    private String viewType;
    private Collection<BaseViewColumnEntity> baseViewColumnsByViewId;
    private Collection<BaseViewDeptEntity> baseViewDeptsByViewId;

    @Id
    @Column(name = "ViewId", nullable = false)
    public int getViewId() {
        return viewId;
    }

    public void setViewId(int viewId) {
        this.viewId = viewId;
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
    @Column(name = "Category", nullable = true, length = 50)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    @Basic
    @Column(name = "Sort", nullable = true, precision = 2)
    public BigDecimal getSort() {
        return sort;
    }

    public void setSort(BigDecimal sort) {
        this.sort = sort;
    }

    @Basic
    @Column(name = "ViewType", nullable = true, length = 20)
    public String getViewType() {
        return viewType;
    }

    public void setViewType(String viewType) {
        this.viewType = viewType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseViewEntity that = (BaseViewEntity) o;
        return viewId == that.viewId &&
                Objects.equals(viewName, that.viewName) &&
                Objects.equals(cnName, that.cnName) &&
                Objects.equals(description, that.description) &&
                Objects.equals(timeFilterColumn, that.timeFilterColumn) &&
                Objects.equals(deptFilterColumn, that.deptFilterColumn) &&
                Objects.equals(category, that.category) &&
                Objects.equals(creatorId, that.creatorId) &&
                Objects.equals(creator, that.creator) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(sort, that.sort) &&
                Objects.equals(viewType, that.viewType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(viewId, viewName, cnName, description, timeFilterColumn, deptFilterColumn, category, creatorId, creator, createTime, sort, viewType);
    }

    @OneToMany(mappedBy = "baseViewByViewId")
    public Collection<BaseViewColumnEntity> getBaseViewColumnsByViewId() {
        return baseViewColumnsByViewId;
    }

    public void setBaseViewColumnsByViewId(Collection<BaseViewColumnEntity> baseViewColumnsByViewId) {
        this.baseViewColumnsByViewId = baseViewColumnsByViewId;
    }

    @OneToMany(mappedBy = "baseViewByViewId")
    public Collection<BaseViewDeptEntity> getBaseViewDeptsByViewId() {
        return baseViewDeptsByViewId;
    }

    public void setBaseViewDeptsByViewId(Collection<BaseViewDeptEntity> baseViewDeptsByViewId) {
        this.baseViewDeptsByViewId = baseViewDeptsByViewId;
    }
}
