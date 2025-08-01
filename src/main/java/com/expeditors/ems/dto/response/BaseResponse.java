package com.expeditors.ems.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse  extends BaseResponseWoData {
    private Object data;

    public BaseResponse(String status,String message, Object data){
        super(status, message);
        this.data = data;
    }
}
