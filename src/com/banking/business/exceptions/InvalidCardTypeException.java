package com.banking.business.exceptions;

import com.banking.core.exceptions.BaseException;

public class InvalidCardTypeException extends BaseException {
    public InvalidCardTypeException(String message) {
        super(message);
    }
}
