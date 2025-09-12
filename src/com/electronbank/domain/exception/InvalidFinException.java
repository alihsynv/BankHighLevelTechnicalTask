package com.electronbank.domain.exception;

public class InvalidFinException extends RuntimeException {
    public InvalidFinException(String message) {
        super(message);
    }
}
