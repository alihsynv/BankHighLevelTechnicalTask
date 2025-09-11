package com.electronbank.application.service;

import com.electronbank.domain.entity.User;

public interface UserService {
    void registerUser(User user);
    User login(String fin, String password);
}
