package com.banking.business.exceptions;

import com.banking.core.exceptions.BaseException;

public class InvaliidPhoneNumberException extends BaseException {
    public InvaliidPhoneNumberException(String message) {
        super(message);
    }
}
