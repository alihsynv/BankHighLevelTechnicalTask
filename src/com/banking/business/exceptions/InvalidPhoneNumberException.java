package com.banking.business.exceptions;

import com.banking.core.exceptions.BaseException;

public class InvalidPhoneNumberException extends BaseException {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}
