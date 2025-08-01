package com.expeditors.ems.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TasksResponse {
    private int id;
    private String devname;
    private String managerName;
    private String taskName;
    private String taskStatus;
    private LocalDateTime createdAt;


}