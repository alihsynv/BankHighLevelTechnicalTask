package com.banking.business.exceptions;

import com.banking.core.exceptions.BaseException;

public class InvalidLoginException extends BaseException {
    public InvalidLoginException(String message) {
        super(message);
    }
}
