package com.banking;

import com.banking.business.concretes.UserManager;
import com.banking.business.validationRules.UserValidator;
import com.banking.core.exceptions.BaseException;
import com.banking.dataAccess.concretes.inmem.InMemoryUserRepository;

import java.time.LocalDate;

public class BankingApp {
    public static void main(String[] args) {
        try {
            UserValidator userValidator = new UserValidator(new InMemoryUserRepository());
            UserManager userManager = new UserManager(new  InMemoryUserRepository());
            userManager.registerUser("6x9mvl4", "Ali123456!", "Ali",
                    "Huseynov", LocalDate.of(2000, 3, 17), "51", "8869807");
            userManager.login("6x9mvl4", "Ali123456!");
            userManager.findAllUsers().forEach(System.out::println);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }
}
