package com.sobchuk.forum.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="forum.comments")
public class Comment extends AuditDate{

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @NotNull
    @Column(name="comment_text")
    private String text;

    @NotNull
    @Size(min=3, max=35)
    @Column(name="created_by")
    private String createdBy;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "topic_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Topic topic;

    public Comment(){
    }

    public Comment(@NotNull String text, @NotNull @Size(min = 3, max = 35) String createdBy, Topic topic) {
        this.text = text;
        this.createdBy = createdBy;
        this.topic = topic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
