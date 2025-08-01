package com.expeditors.ems.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "candidate")
public class CandidateEntity {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "interviewer_id")
    private int interviewerId;

    @Column(name = "scheduled_at")
    private LocalDateTime scheduledAt;


    @ManyToOne
    @JoinColumn(name="status_id", referencedColumnName = "id")


    private HIringStatusEntity hIringStatusEntity;

    @ManyToOne
    @JoinColumn(name = "role_id",referencedColumnName = "id")

    private Role role;

}
