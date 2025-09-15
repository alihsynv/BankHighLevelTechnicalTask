package com.banking.business.exceptions;

public class InvalidPasswordException extends InvalidRegisterException {
    public InvalidPasswordException(String message) {
        super(message);
    }
}
