package com.banking.exceptions.custom;

import com.banking.exceptions.BaseException;

public class InsufficientBalanceException extends BaseException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
