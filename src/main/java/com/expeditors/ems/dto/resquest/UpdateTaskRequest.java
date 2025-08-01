package com.expeditors.ems.dto.resquest;

import lombok.Data;

@Data
public class UpdateTaskRequest {
    private int id;
    private String status;

}
