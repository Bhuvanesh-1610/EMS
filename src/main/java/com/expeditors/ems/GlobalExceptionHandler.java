package com.expeditors.ems;

import com.expeditors.ems.dto.response.BaseResponseWoData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<?> handleException(Exception e) {
        log.error("Error happened: ", e);
        final BaseResponseWoData baseResponseWoData = new BaseResponseWoData("Fail", e.getMessage());
        return ResponseEntity.status(500).body(baseResponseWoData);
    }
}