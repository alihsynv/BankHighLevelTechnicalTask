package com.banking.business.exceptions;

import com.banking.core.exceptions.BaseException;

public class TransactionNotFoundException extends BaseException {
    public TransactionNotFoundException(String message) {
        super(message);
    }
}
