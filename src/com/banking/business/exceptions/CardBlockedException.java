package com.banking.business.exceptions;

import com.banking.core.exceptions.BaseException;

public class CardBlockedException extends BaseException {
    public CardBlockedException(String message) {
        super(message);
    }
}
