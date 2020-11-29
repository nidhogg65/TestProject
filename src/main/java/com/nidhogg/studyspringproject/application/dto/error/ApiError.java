package com.nidhogg.studyspringproject.application.dto.error;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ApiError {

    private HttpStatus status;
    private LocalDateTime timestamp;
    private String message;

    public ApiError() {
    }

    public ApiError(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public ApiError(HttpStatus status, LocalDateTime timestamp) {
        this.status = status;
        this.timestamp = timestamp;
    }

    public ApiError(HttpStatus status, LocalDateTime timestamp, String message) {
        this.status = status;
        this.timestamp = timestamp;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ApiError{" +
                "status=" + status +
                ", timestamp=" + timestamp +
                ", message='" + message + '\'' +
                '}';
    }
}
