package com.banking.exceptions.custom;

import com.banking.exceptions.BaseException;

public class TransactionNotFoundException extends BaseException {
    public TransactionNotFoundException(String message) {
        super(message);
    }
}
