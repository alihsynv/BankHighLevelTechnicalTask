package com.banking.exceptions.custom;

import com.banking.exceptions.BaseException;

public class CardBlockedException extends BaseException {
    public CardBlockedException(String message) {
        super(message);
    }
}
