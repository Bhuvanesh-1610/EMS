package com.expeditors.ems.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class CandidateResponse {
    private int id;
    private String name;
    private String email;
    private int interviewerId;
    private int statusId;
    private LocalDateTime scheduledAt;
    private int roleId;
}
