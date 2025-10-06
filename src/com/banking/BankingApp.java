package com.banking;

import com.banking.exceptions.BaseException;
import com.banking.dataAccess.concretes.inmem.InMemoryUserRepository;
import com.banking.service.concretes.UserManager;

import java.time.LocalDate;

public class BankingApp {
    public static void main(String[] args) {
        try {
            UserManager userManager = new UserManager(new InMemoryUserRepository());
            userManager.registerUser("6x9mvl4",
                    "Ali123456!",
                    "Ali",
                    "Huseynov",
                    LocalDate.of(2000, 3, 17),
                    "51",
                    "8869807");
            userManager.login("6x9mvl4", "Ali123456!");
            userManager.findAllUsers().forEach(System.out::println);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }
}
