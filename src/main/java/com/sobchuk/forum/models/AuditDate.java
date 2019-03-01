package com.sobchuk.forum.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"date_add", "date_update"},
        allowGetters = true
)
public abstract class AuditDate implements Serializable {

    public static final String DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";

    //@Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = DATE_FORMAT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    @Column(name = "date_add", nullable = false, updatable = false)
    @CreatedDate
    private Date dateAdd;

    //@Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = DATE_FORMAT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    @Column(name = "date_update", nullable = false)
    @LastModifiedDate
    private Date dateUpdate;

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }
}
