package com.nidhogg.studyspringproject.application.exception;

public class NotEnoughMoneyException extends RuntimeException {

    public NotEnoughMoneyException() {
        super("Sender's account does not have enough money for current operation.");
    }
}
