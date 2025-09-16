package com.banking.business.exceptions;

import com.banking.core.exceptions.BaseException;

public class InvalidNameException extends BaseException {
    public InvalidNameException(String message) {
        super(message);
    }
}
