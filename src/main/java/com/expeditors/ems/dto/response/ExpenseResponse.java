package com.expeditors.ems.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ExpenseResponse {
    private int id;
    private int userId;
    private int typeId;
    private int statusId;
    private LocalDateTime spentAt;
    private  double amount;
    private String description;
    private LocalDateTime accountedAt;
    private int accountedBy;
    private LocalDateTime createAt;
}
