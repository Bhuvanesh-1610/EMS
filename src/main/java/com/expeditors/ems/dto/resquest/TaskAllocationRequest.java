package com.expeditors.ems.dto.resquest;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TaskAllocationRequest {
        private int task_id;
        private int developerid;
        private int assignedby;
        private LocalDateTime assignedDate;
        private String status;
}
