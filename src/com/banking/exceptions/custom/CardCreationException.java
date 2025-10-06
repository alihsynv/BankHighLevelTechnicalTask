package com.banking.exceptions.custom;

import com.banking.exceptions.BaseException;

public class CardCreationException extends BaseException {
    public CardCreationException(String message) {
        super(message);
    }
}
