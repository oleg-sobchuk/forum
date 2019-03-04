package com.sobchuk.forum.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="forum.topics")
public class Topic extends AuditDate{

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @NotNull
    @Size(min=1, max=55)
    @Column(name="topic_name", unique = true)
    private String name;

    @Size(min=5, message="min length is 5")
    @Column(name="topic_desc")
    private String desc;

    @Size(min=3, max=35)
    @Column(name="created_by")
    private String createdBy;

    @Size(min=3, max=35)
    @Column(name="updated_by")
    private String updatedBy;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "theme_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Theme theme;

    public Topic() {
    }

    public Topic(@NotNull @Size(min = 1, max = 55) String name, @Size(min = 5) String desc,
                 @Size(min = 3, max = 35) String createdBy, Theme theme) {
        this.name = name;
        this.desc = desc;
        this.createdBy = createdBy;
        this.updatedBy = createdBy;
        this.theme = theme;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }
}
