package application.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "SystemConfig", schema = "dbo")
public class SystemConfigEntity {
    private int configId;
    private String configName;
    private String configValue;
    private String remark;
    private String lastModifier;
    private Timestamp lastModifyTime;

    @Id
    @Column(name = "ConfigId", nullable = false)
    public int getConfigId() {
        return configId;
    }

    public void setConfigId(int configId) {
        this.configId = configId;
    }

    @Basic
    @Column(name = "ConfigName", nullable = false, length = 300)
    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    @Basic
    @Column(name = "ConfigValue", nullable = true, length = 2147483647)
    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    @Basic
    @Column(name = "Remark", nullable = true, length = 500)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "LastModifier", nullable = false, length = 32)
    public String getLastModifier() {
        return lastModifier;
    }

    public void setLastModifier(String lastModifier) {
        this.lastModifier = lastModifier;
    }

    @Basic
    @Column(name = "LastModifyTime", nullable = false)
    public Timestamp getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Timestamp lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SystemConfigEntity that = (SystemConfigEntity) o;
        return configId == that.configId &&
                Objects.equals(configName, that.configName) &&
                Objects.equals(configValue, that.configValue) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(lastModifier, that.lastModifier) &&
                Objects.equals(lastModifyTime, that.lastModifyTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(configId, configName, configValue, remark, lastModifier, lastModifyTime);
    }
}
