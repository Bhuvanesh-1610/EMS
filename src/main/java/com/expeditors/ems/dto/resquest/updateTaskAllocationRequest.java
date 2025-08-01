package com.expeditors.ems.dto.resquest;

import lombok.Data;

@Data
public class updateTaskAllocationRequest {

   private int id;
    private int taskId;
    private int developerId;
    private int assignedBy;
    private String status;
}
