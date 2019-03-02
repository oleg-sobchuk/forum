package com.sobchuk.forum.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCrypt;

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
    @Column(name="id", unique = true)
    private int id;

    @NotNull
    @Size(min=2, max=35)
    @Column(name="user_name", unique = true)
    private String name;

    @Size(min=3, max=55)
    @Column(name="user_email", unique = true)
    @Email
    private String email;

    @NotNull
    @Size(min=3, max=255)
    @Column(name="user_password")
    private String password;


    public User(){
    }

    public User(@NotNull @Size(min = 2, max = 35) String name, @Size(min = 3, max = 55) @Email String email, @NotNull @Size(min = 3, max = 255) String password) {
        this.name = name;
        this.email = email;
        this.password = BCrypt.hashpw(password,BCrypt.gensalt(10));
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
