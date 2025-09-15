package com.electronbank.application.service_impl;

import com.electronbank.application.service.UserService;
import com.electronbank.domain.entity.User;
import com.electronbank.domain.exception.InvalidLoginException;
import com.electronbank.domain.exception.InvalidRegisterException;
import com.electronbank.domain.exception.UserNotFoundException;
import com.electronbank.domain.value.Phone;
import com.electronbank.infrastructure.repository.UserRepository;
import com.electronbank.infrastructure.util.UserValidator;

import java.time.LocalDate;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserValidator userValidator;
    private User user;


    public UserServiceImpl(UserRepository userRepository, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
    }

    public void registerUser(String fin, String password, String name, String surname, LocalDate dateOfBirth, String providerCode, String number) throws InvalidRegisterException {
        Phone phone = Phone.create(providerCode, number);
        User newUser = new User(fin, password, name, surname, dateOfBirth, phone);

        UserValidator.validateFullName(newUser.getName(), newUser.getSurname());
        UserValidator.validateFin(newUser.getFin());
        UserValidator.validateDate(newUser.getDateOfBirth());
        UserValidator.validatePassword(newUser.getPassword());
        userRepository.save(newUser);
    }


    @Override
    public User login(String fin, String password) throws InvalidLoginException {
        if (!userRepository.findByFin(fin)) {
            throw new InvalidLoginException("İstifadəçi tapılmadı. Qeydiyyatdan keçin!");
        }
        if (!userRepository.getUserByFin(fin).getPassword().equals(password)) {
            throw new InvalidLoginException("Şifrə səhvdir!");
        }
        return user;
    }

    @Override
    public User showUserByFin(String fin) throws UserNotFoundException {
        for (User user : userRepository.findAll()) {
            if (user.getFin().equals(fin)) {
                return userRepository.getUserByFin(user.getFin());
            }
        }
        throw new UserNotFoundException("İstifadəçi tapılmadı");
    }

    @Override
    public void logOut() throws UserNotFoundException {
        if (this.user != null) {
            this.user = null;
            System.out.println("Hesabdan çıxış edildi.");
        } else {
            throw new UserNotFoundException("Heç bir istifadəçi daxil olmayıb.");
        }
    }
}
