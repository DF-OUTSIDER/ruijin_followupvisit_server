package application.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "SystemExceptionLog", schema = "dbo")
public class SystemExceptionLogEntity {
    private long id;
    private Timestamp date;
    private String thread;
    private String level;
    private String logger;
    private String message;
    private String exception;

    @Id
    @Column(name = "Id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "Thread", nullable = false, length = 255)
    public String getThread() {
        return thread;
    }

    public void setThread(String thread) {
        this.thread = thread;
    }

    @Basic
    @Column(name = "Level", nullable = false, length = 50)
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Basic
    @Column(name = "Logger", nullable = false, length = 255)
    public String getLogger() {
        return logger;
    }

    public void setLogger(String logger) {
        this.logger = logger;
    }

    @Basic
    @Column(name = "Message", nullable = false, length = 2147483647)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "Exception", nullable = true, length = 2147483647)
    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SystemExceptionLogEntity that = (SystemExceptionLogEntity) o;
        return id == that.id &&
                Objects.equals(date, that.date) &&
                Objects.equals(thread, that.thread) &&
                Objects.equals(level, that.level) &&
                Objects.equals(logger, that.logger) &&
                Objects.equals(message, that.message) &&
                Objects.equals(exception, that.exception);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, date, thread, level, logger, message, exception);
    }
}
