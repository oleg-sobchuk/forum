package com.sobchuk.forum.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "forum.themes")
public class Theme extends AuditDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true)
    private Long id;

    @NotNull
    @Size(min=1, max=55)
    @Column(name="theme_name", unique = true)
    private String name;


    @Size(min=3, max=35)
    @Column(name="created_by")
    private String createdBy;

    public Theme(){
    }

    public Theme(@NotNull @Size(min = 1, max = 55) String name, @Size(min=3, max=35) String createdBy) {
        this.name = name;
        this.createdBy = createdBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
