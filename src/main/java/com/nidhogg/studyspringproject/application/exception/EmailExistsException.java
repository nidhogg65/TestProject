package com.nidhogg.studyspringproject.application.exception;

public class EmailExistsException extends RuntimeException {

    public EmailExistsException(String email) {
        super(String.format("Account with that email address: %s already exists.", email));
    }

}
