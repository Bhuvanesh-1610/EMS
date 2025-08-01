package com.expeditors.ems.dto.resquest;

import lombok.Data;

@Data

public class UserUpdateRequest {

    private int id;
    private String name;
    private String email;

}
