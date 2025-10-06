package com.banking.exceptions.custom;

import com.banking.exceptions.BaseException;

public class InsufficientLimitException extends BaseException {
    public InsufficientLimitException(String message) {
        super(message);
    }
}
