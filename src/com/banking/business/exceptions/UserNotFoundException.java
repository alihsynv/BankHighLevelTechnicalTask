package com.banking.business.exceptions;

import com.banking.core.exceptions.BaseException;

public class UserNotFoundException extends BaseException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
