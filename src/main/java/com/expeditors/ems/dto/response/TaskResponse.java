package com.expeditors.ems.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TaskResponse {
    private int id;
    private String name;
    private String description;
    private int createdBy;
    private LocalDateTime createdAt;
}
