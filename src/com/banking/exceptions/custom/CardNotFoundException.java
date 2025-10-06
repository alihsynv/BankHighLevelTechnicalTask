package com.banking.exceptions.custom;

import com.banking.exceptions.BaseException;

public class CardNotFoundException extends BaseException {
    public CardNotFoundException(String message) {
        super(message);
    }
}
