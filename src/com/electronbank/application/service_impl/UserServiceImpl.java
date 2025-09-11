package com.electronbank.application.service_impl;

import com.electronbank.application.service.UserService;
import com.electronbank.domain.entity.User;
import com.electronbank.domain.exception.InvalidRegisterException;
import com.electronbank.infrastructure.repository.UserRepository;
import com.electronbank.infrastructure.util.UserValidator;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) throws InvalidRegisterException {
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new InvalidRegisterException("Ad boş ola bilməz!");
        }
        if (user.getSurname() == null || user.getSurname().isEmpty()) {
            throw new InvalidRegisterException("Soyad boş ola bilməz!");
        }
        if (user.getFin() == null || user.getFin().isEmpty()) {
            throw new InvalidRegisterException("FIN kod boş ola bilməz!");
        }
        if (userRepository.findByFin(user.getFin())) {
            throw new InvalidRegisterException("İstifadəçi artıq mövcuddur. Giriş edin!");
        }

        UserValidator.isValidDate(user.getDateOfBirth());
        UserValidator.validatePassword(user.getPassword());

    }


    @Override
    public User login(String fin, String password) {
        return null;
    }
}
