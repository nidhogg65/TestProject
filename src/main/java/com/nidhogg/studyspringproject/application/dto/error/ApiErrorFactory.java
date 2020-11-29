package com.nidhogg.studyspringproject.application.dto.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.LocalDateTime;

@Component
public class ApiErrorFactory {

    private final Clock clock;

    @Autowired
    public ApiErrorFactory(Clock clock) {
        this.clock = clock;
    }

    public ApiError produceApiError() {
        return new ApiError(LocalDateTime.now(clock));
    }

    public ApiError produceApiErrorWithStatus(HttpStatus status) {
        return new ApiError(status, LocalDateTime.now(clock));
    }

    public ApiError produceApiErrorWithStatusAndMessage(HttpStatus status, String message) {
        return new ApiError(status, LocalDateTime.now(clock), message);
    }

}
