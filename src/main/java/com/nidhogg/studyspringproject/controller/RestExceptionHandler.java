package com.nidhogg.studyspringproject.controller;

import com.nidhogg.studyspringproject.application.dto.error.ApiError;
import com.nidhogg.studyspringproject.application.dto.error.ApiErrorFactory;
import com.nidhogg.studyspringproject.application.exception.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private final ApiErrorFactory errorFactory;

    @Autowired
    public RestExceptionHandler(ApiErrorFactory errorFactory) {
        this.errorFactory = errorFactory;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(EmailExistsException.class)
    protected ApiError handleEmailExistsException(EmailExistsException exception) {
        return errorFactory.produceApiErrorWithStatusAndMessage(HttpStatus.CONFLICT, exception.getMessage());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiError error = errorFactory.produceApiErrorWithStatusAndMessage(status, ex.getMessage());
        return new ResponseEntity<>(error, headers, status);
    }
}
