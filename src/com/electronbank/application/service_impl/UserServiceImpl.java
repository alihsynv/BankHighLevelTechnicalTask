package com.electronbank.application.service_impl;

import com.electronbank.application.service.UserService;
import com.electronbank.domain.entity.User;
import com.electronbank.domain.exception.InvalidLoginException;
import com.electronbank.domain.exception.InvalidRegisterException;
import com.electronbank.infrastructure.repository.UserRepository;
import com.electronbank.infrastructure.util.UserValidator;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserValidator userValidator;
    private User user;


    public UserServiceImpl(UserRepository userRepository, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
    }

    @Override
    public void registerUser(User user) throws InvalidRegisterException {
        UserValidator.validateFullName(user.getName(), user.getSurname());
        UserValidator.validateFin(user.getFin());
        UserValidator.validateDate(user.getDateOfBirth());
        UserValidator.validatePassword(user.getPassword());
        UserValidator.validatePhone(user.getPhone());
        userRepository.save(user);
    }


    @Override
    public User login(String fin, String password) throws InvalidLoginException {
        if (!userRepository.findByFin(fin)) {
            throw new InvalidLoginException("İstifadəçi tapılmadı. Qeydiyyatdan keçin!");
        }
        if (!userRepository.getUserByFin(fin).getPassword().equals(password)) {
            throw new InvalidLoginException("Şifrə səhvdir!");
        }
        return  user;
    }
}
