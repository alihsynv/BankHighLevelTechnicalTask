package com.banking.exceptions.custom;

import com.banking.exceptions.BaseException;

public class InvalidPasswordException extends BaseException {
    public InvalidPasswordException(String message) {
        super(message);
    }
}
