package com.banking.exceptions.custom;

import com.banking.exceptions.BaseException;

public class InvalidNameException extends BaseException {
    public InvalidNameException(String message) {
        super(message);
    }
}
