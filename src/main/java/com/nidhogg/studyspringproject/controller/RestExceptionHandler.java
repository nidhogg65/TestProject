package com.nidhogg.studyspringproject.controller;

import com.nidhogg.studyspringproject.application.exception.EntityNotFoundException;
import com.nidhogg.studyspringproject.dto.error.ApiError;
import com.nidhogg.studyspringproject.factory.ApiErrorFactory;
import com.nidhogg.studyspringproject.application.exception.EmailExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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


@Slf4j
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private final ApiErrorFactory errorFactory;

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(EmailExistsException.class)
    protected ApiError handleEmailExistsException(EmailExistsException exception) {
        log.error(exception.getMessage(), exception);
        return errorFactory.produceApiErrorWithStatusAndMessage(HttpStatus.CONFLICT, exception.getMessage());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(EntityNotFoundException.class)
    protected ApiError handleEntityNotFoundException(EntityNotFoundException exception) {
        log.error(exception.getMessage(), exception);
        return errorFactory.produceApiErrorWithStatusAndMessage(HttpStatus.CONFLICT, exception.getMessage());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("Error occurred during bean validation.", ex);
        ApiError error = errorFactory.produceApiErrorWithStatusAndMessage(status, ex.getMessage());
        return new ResponseEntity<>(error, headers, status);
    }
}
