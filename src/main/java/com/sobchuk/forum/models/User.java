package com.sobchuk.forum.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="forum.users")
public class User extends AuditDate{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    private int id;

    @NotNull
    @Size(min=3, max=35)
    @Column(name="user_name")
    private String name;

    @Column(name="user_email")
    @Email
    private String email;

    @NotNull
    @Size(min=5, max=55)
    @Column(name="user_password")
    private String password;


    public User(){
    }

    public User(String name, String password, String email) {
        //this.login = login;
        this.name = name;
        this.password = password;
        this.email = email;
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

}
