package com.expeditors.ems.dto.response;

import lombok.Data;

@Data
public class UserResponse {
    private String name;
    private int id;
    private String email;
    private String role;


}
