package com.expeditors.ems.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponseWoData {
    private String status;
    private String message;
    public BaseResponseWoData(String status, String message) {
        this.status = status;
        this.message= message;


    }
}