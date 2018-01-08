package application.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "ExternalSystemRegister", schema = "dbo")
public class ExternalSystemRegisterEntity {
    private int sysId;
    private String systemName;
    private String key;
    private Collection<ExternalSystemAccessLogEntity> externalSystemAccessLogsBySysId;

    @Id
    @Column(name = "SysId", nullable = false)
    public int getSysId() {
        return sysId;
    }

    public void setSysId(int sysId) {
        this.sysId = sysId;
    }

    @Basic
    @Column(name = "SystemName", nullable = false, length = 50)
    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    @Basic
    @Column(name = "Key", nullable = false, length = 500)
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExternalSystemRegisterEntity that = (ExternalSystemRegisterEntity) o;
        return sysId == that.sysId &&
                Objects.equals(systemName, that.systemName) &&
                Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sysId, systemName, key);
    }

    @OneToMany(mappedBy = "externalSystemRegisterBySysId")
    public Collection<ExternalSystemAccessLogEntity> getExternalSystemAccessLogsBySysId() {
        return externalSystemAccessLogsBySysId;
    }

    public void setExternalSystemAccessLogsBySysId(Collection<ExternalSystemAccessLogEntity> externalSystemAccessLogsBySysId) {
        this.externalSystemAccessLogsBySysId = externalSystemAccessLogsBySysId;
    }
}
