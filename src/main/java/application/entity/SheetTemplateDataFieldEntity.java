package application.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "SheetTemplateDataField", schema = "dbo")
public class SheetTemplateDataFieldEntity {
    private long id;
    private int sheetTemplateDataId;
    private UUID dataFieldId;
    private String label;
    private String dataField;
    private short exportData;
    private SheetTemplateDataEntity sheetTemplateDataBySheetTemplateDataId;

    @Id
    @Column(name = "Id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "SheetTemplateDataId", nullable = false)
    public int getSheetTemplateDataId() {
        return sheetTemplateDataId;
    }

    public void setSheetTemplateDataId(int sheetTemplateDataId) {
        this.sheetTemplateDataId = sheetTemplateDataId;
    }

    @Basic
    @Column(name = "DataFieldId", nullable = false)
    public UUID getDataFieldId() {
        return dataFieldId;
    }

    public void setDataFieldId(UUID dataFieldId) {
        this.dataFieldId = dataFieldId;
    }

    @Basic
    @Column(name = "Label", nullable = true, length = 500)
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Basic
    @Column(name = "DataField", nullable = true, length = 2147483647)
    public String getDataField() {
        return dataField;
    }

    public void setDataField(String dataField) {
        this.dataField = dataField;
    }

    @Basic
    @Column(name = "ExportData", nullable = false)
    public short getExportData() {
        return exportData;
    }

    public void setExportData(short exportData) {
        this.exportData = exportData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SheetTemplateDataFieldEntity that = (SheetTemplateDataFieldEntity) o;
        return id == that.id &&
                sheetTemplateDataId == that.sheetTemplateDataId &&
                exportData == that.exportData &&
                Objects.equals(dataFieldId, that.dataFieldId) &&
                Objects.equals(label, that.label) &&
                Objects.equals(dataField, that.dataField);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, sheetTemplateDataId, dataFieldId, label, dataField, exportData);
    }

    @ManyToOne
    @JoinColumn(name = "SheetTemplateDataId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public SheetTemplateDataEntity getSheetTemplateDataBySheetTemplateDataId() {
        return sheetTemplateDataBySheetTemplateDataId;
    }

    public void setSheetTemplateDataBySheetTemplateDataId(SheetTemplateDataEntity sheetTemplateDataBySheetTemplateDataId) {
        this.sheetTemplateDataBySheetTemplateDataId = sheetTemplateDataBySheetTemplateDataId;
    }
}
