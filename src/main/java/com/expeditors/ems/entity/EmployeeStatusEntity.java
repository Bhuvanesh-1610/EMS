package com.expeditors.ems.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "expense_status")
public class EmployeeStatusEntity
{
    @Id
    @Column(name = "id")
    private int id;

    @Column(name="status")
    private String status;



}
