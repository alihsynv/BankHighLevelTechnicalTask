package com.electronbank.domain.exception;

public class InvalidPasswordException extends InvalidRegisterException {
    public InvalidPasswordException(String message) {
        super(message);
    }
}
