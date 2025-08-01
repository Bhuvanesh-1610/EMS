package com.expeditors.ems.dto.response;

import lombok.Data;

@Data

public class LoginResponse{
    private String email;
    private String token;
    private boolean auth;
    private String message;
    private String role;

    public LoginResponse(String email, String token, boolean auth, String message , String role) {
        this.email = email;
        this.token = token;
        this.auth = auth;
        this.message = message;
        this.role=role;
    }
}
