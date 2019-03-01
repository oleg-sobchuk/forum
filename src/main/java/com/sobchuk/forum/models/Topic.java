package com.sobchuk.forum.models;

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
    @Column(name="topic_name")
    private String name;

    @Column(name="topic_desc")
    private String desc;

    @NotNull
    @Size(min=3, max=35)
    @Column(name="created_by")
    private String createdBy;

    @NotNull
    @Size(min=3, max=35)
    @Column(name="updated_by")
    private String updatedBy;

    public Topic() {
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
}
