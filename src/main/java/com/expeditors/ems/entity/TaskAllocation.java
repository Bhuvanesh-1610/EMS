package com.expeditors.ems.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "task_allocation")
public class TaskAllocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "task_id",referencedColumnName = "id")
    private Task task;

    @ManyToOne()
    @JoinColumn(name="developer_id",referencedColumnName = "id")
    private UserDetails devId;

    @ManyToOne()
    @JoinColumn(name="assigned_by",referencedColumnName = "id")
    private UserDetails userDetails1;

    @Column(name = "assigned_at")
    private LocalDateTime assignedDate;

    @Column(name = "status")
    private String status;

}
