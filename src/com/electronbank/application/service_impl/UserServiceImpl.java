package com.electronbank.application.service_impl;

import com.electronbank.application.service.UserService;
import com.electronbank.domain.entity.User;
import com.electronbank.domain.exception.InvalidRegisterException;
import com.electronbank.infrastructure.repository.UserRepository;
import com.electronbank.infrastructure.util.UserValidator;

public class UserServiceImpl implements UserService {

    @Override
    public void registerUser(User user) throws InvalidRegisterException {
        UserValidator.validateFullName(user.getName(), user.getSurname());
        UserValidator.validateFin(user.getFin());
        UserValidator.validateDate(user.getDateOfBirth());
        UserValidator.validatePassword(user.getPassword());

    }


    @Override
    public User login(String fin, String password) {
        return null;
    }
}
