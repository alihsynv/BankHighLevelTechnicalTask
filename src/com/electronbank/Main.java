package com.electronbank;


import com.electronbank.application.service_impl.UserServiceImpl;
import com.electronbank.domain.entity.User;
import com.electronbank.domain.exception.InvalidLoginException;
import com.electronbank.domain.exception.InvalidRegisterException;
import com.electronbank.domain.value.Phone;
import com.electronbank.infrastructure.repository.inMemory.InMemoryUserRepository;
import com.electronbank.infrastructure.util.UserValidator;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        InMemoryUserRepository userRepository = new InMemoryUserRepository();

        UserValidator validator = new UserValidator(userRepository);

        UserServiceImpl userService = new UserServiceImpl(userRepository, validator);

        try {
            userService.registerUser("6x9mvl4", "123Aa123!", "Ali", "Huseynov", LocalDate.of(2000,3,17), "51", "8869807");
            userService.registerUser("6x9mvl3", "123Aa123!", "Ali", "Huseynov", LocalDate.of(2000,3,17), "51", "8869807");
        } catch (InvalidRegisterException e) {
            System.out.println(e.getMessage());
        }

        try {
            userService.login("6x9mvl4", "123Aa123!");
        } catch (InvalidLoginException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(userRepository.findAll());


    }
}
