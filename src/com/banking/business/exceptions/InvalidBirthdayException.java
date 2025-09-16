package com.banking.business.exceptions;
import com.banking.core.exceptions.BaseException;

public class InvalidBirthdayException extends BaseException {
    public InvalidBirthdayException(String message) {
        super(message);
    }
}
