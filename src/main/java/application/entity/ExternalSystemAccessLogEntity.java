package application.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "ExternalSystemAccessLog", schema = "dbo")
public class ExternalSystemAccessLogEntity {
    private long logId;
    private int sysId;
    private String user;
    private Timestamp accessTime;
    private String clientIp;
    private String controller;
    private String action;
    private String token;
    private ExternalSystemRegisterEntity externalSystemRegisterBySysId;

    @Id
    @Column(name = "LogId", nullable = false)
    public long getLogId() {
        return logId;
    }

    public void setLogId(long logId) {
        this.logId = logId;
    }

    @Basic
    @Column(name = "SysId", nullable = false)
    public int getSysId() {
        return sysId;
    }

    public void setSysId(int sysId) {
        this.sysId = sysId;
    }

    @Basic
    @Column(name = "User", nullable = true, length = 50)
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Basic
    @Column(name = "AccessTime", nullable = false)
    public Timestamp getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Timestamp accessTime) {
        this.accessTime = accessTime;
    }

    @Basic
    @Column(name = "ClientIP", nullable = true, length = 120)
    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    @Basic
    @Column(name = "Controller", nullable = true, length = 50)
    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    @Basic
    @Column(name = "Action", nullable = true, length = 150)
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Basic
    @Column(name = "Token", nullable = true, length = 2147483647)
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExternalSystemAccessLogEntity that = (ExternalSystemAccessLogEntity) o;
        return logId == that.logId &&
                sysId == that.sysId &&
                Objects.equals(user, that.user) &&
                Objects.equals(accessTime, that.accessTime) &&
                Objects.equals(clientIp, that.clientIp) &&
                Objects.equals(controller, that.controller) &&
                Objects.equals(action, that.action) &&
                Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {

        return Objects.hash(logId, sysId, user, accessTime, clientIp, controller, action, token);
    }

    @ManyToOne
    @JoinColumn(name = "SysId", referencedColumnName = "SysId", nullable = false, insertable = false, updatable = false)
    public ExternalSystemRegisterEntity getExternalSystemRegisterBySysId() {
        return externalSystemRegisterBySysId;
    }

    public void setExternalSystemRegisterBySysId(ExternalSystemRegisterEntity externalSystemRegisterBySysId) {
        this.externalSystemRegisterBySysId = externalSystemRegisterBySysId;
    }
}
