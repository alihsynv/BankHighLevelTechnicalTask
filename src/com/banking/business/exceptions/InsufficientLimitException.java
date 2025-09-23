package com.banking.business.exceptions;

import com.banking.core.exceptions.BaseException;

public class InsufficientLimitException extends BaseException {
    public InsufficientLimitException(String message) {
        super(message);
    }
}
