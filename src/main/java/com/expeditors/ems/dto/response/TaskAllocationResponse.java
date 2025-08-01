package com.expeditors.ems.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TaskAllocationResponse {
    private int id;
    private int task_id;
    private int developerid;
    private int assignedby;
    private LocalDateTime assignedDate;
    private String status;
}
