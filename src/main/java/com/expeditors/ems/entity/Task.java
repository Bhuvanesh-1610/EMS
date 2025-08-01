package com.expeditors.ems.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "task")
public class Task {
   @Id

    @Column (name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at")
    public LocalDateTime createdAt;



    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "id")

    private UserDetails userDetails;
}
