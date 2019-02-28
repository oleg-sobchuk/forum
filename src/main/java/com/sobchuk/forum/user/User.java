package com.sobchuk.forum.user;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="users")
public class User {

    public static final String DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";

    @Id
    @GeneratedValue
    @Column(name="user_id")
    private int id;

    @NotNull
    @Size(min=2, max=35)
    @Column(name="user_name")
    private String name;

    @Column(name="email")
    private String email;

    @NotNull
    @Size(min=5, max=55)
    @Column(name="user_password")
    private String password;

    @DateTimeFormat(pattern = DATE_FORMAT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    @Column(name="date_add")
    private Date dateAdd;

    @DateTimeFormat(pattern = DATE_FORMAT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    @Column(name="date_update")
    private Date dateUpdate;

    public User(){
    }

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
        Date now = new Date();
        dateAdd = now;
        dateUpdate = now;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
