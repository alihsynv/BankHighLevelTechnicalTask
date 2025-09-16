package com.banking.business.exceptions;

import com.banking.core.exceptions.BaseException;

public class InvalidFinException extends BaseException {
    public InvalidFinException(String message) {
        super(message);
    }
}
