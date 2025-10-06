package com.banking.exceptions.custom;

import com.banking.exceptions.BaseException;

public class InvalidPhoneNumberException extends BaseException {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}
