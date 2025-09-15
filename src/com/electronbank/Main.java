package com.electronbank;


import com.electronbank.application.service_impl.UserServiceImpl;
import com.electronbank.domain.entity.User;
import com.electronbank.domain.exception.InvalidLoginException;
import com.electronbank.domain.exception.InvalidRegisterException;
import com.electronbank.domain.value.Phone;
import com.electronbank.infrastructure.repository.UserRepository;
import com.electronbank.infrastructure.repository.inMemory.InMemoryUserRepository;
import com.electronbank.infrastructure.util.UserValidator;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Repository
        InMemoryUserRepository userRepository = new InMemoryUserRepository();

        // Validator (istəyə görə istifadə olunur)
        UserValidator validator = new UserValidator(userRepository);

        // Service
        UserServiceImpl userService = new UserServiceImpl(userRepository, validator);

        // 1️⃣ Qeydiyyat
        try {
            User newUser = new User("6x9mvl4", "Ali@123456", "Əli", "Hüseynov", LocalDate.of(2000, 3,17) , new Phone("51","8869807"));
            userService.registerUser(newUser);
        } catch (InvalidRegisterException e) {
            System.out.println(e.getMessage());
        }

        // 2️⃣ Login
        try {
            userService.login("6x9mvl4", "Ali@123456");
        } catch (InvalidLoginException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(userRepository.findAll());

        // 3️⃣ Profil məlumatlarını görmək

    }
}
