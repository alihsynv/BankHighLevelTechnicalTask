package com.banking.business.exceptions;

import com.banking.core.exceptions.BaseException;

public class InsufficientBalanceException extends BaseException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
