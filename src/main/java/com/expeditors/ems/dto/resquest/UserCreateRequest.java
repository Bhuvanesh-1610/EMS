package com.expeditors.ems.dto.resquest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateRequest {
    private int id;
    private String name;
    private String email;
    private int role_id;
    private String password;
}
