package com.expeditors.ems.dto.resquest;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Tasks {
    private int id;
    private String name;
    private String description;
    private int createdBy;
    private LocalDateTime createdAt;

}
