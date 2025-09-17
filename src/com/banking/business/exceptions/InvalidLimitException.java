package com.banking.business.exceptions;

import com.banking.core.exceptions.BaseException;

public class InvalidLimitException extends BaseException {
    public InvalidLimitException(String message) {
        super(message);
    }
}
