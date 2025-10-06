package com.banking.exceptions.custom;

import com.banking.exceptions.BaseException;

public class InvalidLoginException extends BaseException {
    public InvalidLoginException(String message) {
        super(message);
    }
}
