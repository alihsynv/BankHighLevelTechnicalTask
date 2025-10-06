package com.banking.exceptions.custom;
import com.banking.exceptions.BaseException;

public class InvalidBirthdayException extends BaseException {
    public InvalidBirthdayException(String message) {
        super(message);
    }
}
