package com.banking.exceptions.custom;

import com.banking.exceptions.BaseException;

public class InvalidLimitException extends BaseException {
    public InvalidLimitException(String message) {
        super(message);
    }
}
