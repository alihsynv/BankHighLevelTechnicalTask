package com.electronbank.infrastructure.util;

import com.electronbank.domain.exception.InvalidBirthdayException;
import com.electronbank.domain.exception.InvalidPasswordException;

import java.time.LocalDate;

public class UserValidator {
    public static void isValidDate(LocalDate dateOfBirth) throws InvalidBirthdayException {
        if (dateOfBirth == null) {
            throw new InvalidBirthdayException("Doğum tarixini girin!");
        }
        if (dateOfBirth.isAfter(LocalDate.now()) || dateOfBirth.equals(LocalDate.now())) {
            throw new InvalidBirthdayException("Düzgün tarix qeyd edin!");
        }
    }

    public static void validatePassword(String password) throws InvalidPasswordException {
        if (password == null || password.length() < 8) {
            throw new InvalidPasswordException("Şifrə qısadır");
        }

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        String specialChars = "!@#$%^&*()-_+=";

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (specialChars.indexOf(c) > 0) {
                hasSpecial = true;
            }
        }

        if (!hasUppercase) {
            throw new InvalidPasswordException("Şifrədə ən azı 1 böyük hərf olmalıdır!");
        }
        if (!hasLowercase) {
            throw new InvalidPasswordException("Şifrədə ən azı 1 kiçik hərf olmalıdır!");
        }
        if (!hasNumber) {
            throw new RuntimeException("Şifrədə ən azı 1 rəqəm olmalıdır!");
        }
        if (!hasSpecial) {
            throw new RuntimeException("Şifrədə ən azı 1 xüsusi simvol olmalıdır!");
        }
    }
}
