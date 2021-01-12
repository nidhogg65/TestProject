package com.nidhogg.studyspringproject.application.exception;

public class AccountDoesNotExistForUserException extends RuntimeException {

    public AccountDoesNotExistForUserException(String accountUuid) {
        super(String.format("User does not have the following account: %s.", accountUuid));
    }
}
