package com.banking.business.exceptions;

import com.banking.core.exceptions.BaseException;

public class InvalidPasswordException extends BaseException {
    public InvalidPasswordException(String message) {
        super(message);
    }
}
