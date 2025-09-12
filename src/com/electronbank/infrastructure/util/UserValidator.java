package com.electronbank.infrastructure.util;

import com.electronbank.domain.exception.*;
import com.electronbank.domain.value.Phone;
import com.electronbank.infrastructure.repository.UserRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class UserValidator {
    private static UserRepository userRepository;

    public UserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public static void validateFullName(String name, String surname) throws InvalidNameException {
        if (name == null || name.isEmpty()) {
            throw new InvalidNameException("Ad boş ola bilməz!");
        }
        if (surname == null || surname.isEmpty()) {
            throw new InvalidNameException("Soyad boş ola bilməz!");
        }
    }

    public static void validateFin(String fin) throws InvalidFinException {
        if (fin == null || fin.isEmpty()) {
            throw new InvalidFinException("FIN kod boş ola bilməz!");
        }
        if (fin.length() != 7) {
            throw new InvalidFinException("FIN kod 7 simvoldan ibarət olmalıdır!");
        }
        if (userRepository.findByFin(fin)) {
            throw new InvalidFinException("İstifadəçi artıq mövcuddur. Giriş edin!");
        }
    }

    public static void validateDate(LocalDate dateOfBirth) throws InvalidBirthdayException {
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

    public static void validatePhone(Phone phone) {
        List<String> validProvider = Arrays.asList("50", "51", "10", "99", "55", "77", "70", "60");

        if (!validProvider.contains(phone.getProviderCode())) {
            throw new InvaliidPhoneNumberException("Yanlış provider kodu");
        }
        if(phone.getNumber() == null || phone.getNumber().length() != 7) {
            throw new InvaliidPhoneNumberException("Nömrə 7 rəqəm olmalıdır");
        }

        for (char c : phone.getNumber().toCharArray()) {
            if(!Character.isDigit(c)) {
                throw new InvaliidPhoneNumberException("Nömrə yalnız rəqəmlərdən ibarət olmalıdır");
            }
        }
    }
}
