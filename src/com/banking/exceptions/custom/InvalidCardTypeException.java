package com.banking.exceptions.custom;

import com.banking.exceptions.BaseException;

public class InvalidCardTypeException extends BaseException {
    public InvalidCardTypeException(String message) {
        super(message);
    }
}
