package com.luv2code.restdemo.exception;

import java.time.LocalDateTime;

public class StudentErrorResponse {
    private Integer status;
    private String message;
    private LocalDateTime localDateTime;

    public StudentErrorResponse() {
    }

    public StudentErrorResponse(Integer status, String message, LocalDateTime localDateTime) {
        this.status = status;
        this.message = message;
        this.localDateTime = localDateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
