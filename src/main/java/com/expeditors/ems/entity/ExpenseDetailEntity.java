package com.expeditors.ems.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "expense_detail")
public class ExpenseDetailEntity {
    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private UserDetails userDetails;

    @ManyToOne
    @JoinColumn(name = "type_id",referencedColumnName = "id")
    private ExpenseDetailEntity expenseDetailEntity;

    @ManyToOne
    @JoinColumn(name = "status_id",referencedColumnName = "id")
    private EmployeeStatusEntity employeeStatusEntity;

    @Column(name = "spent_at")
    private LocalDateTime spentAt;

    @Column(name = "amount")
    private  double amount;

    @Column(name = "description")
    private String description;

    @Column(name = "accounted_at")
    private LocalDateTime accountedAt;

   @ManyToOne
   @JoinColumn(name = "accounted_by",referencedColumnName = "id")
   private UserDetails userDetails1;

    @Column(name = "created_at")
    private LocalDateTime createAt;
}
