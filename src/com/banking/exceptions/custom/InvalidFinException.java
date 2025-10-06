package com.banking.exceptions.custom;

import com.banking.exceptions.BaseException;

public class InvalidFinException extends BaseException {
    public InvalidFinException(String message) {
        super(message);
    }
}
