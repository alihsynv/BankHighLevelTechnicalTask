package com.electronbank.application.service;

import com.electronbank.domain.entity.User;

public interface UserService {
    User login(String fin, String password);
    User showUserByFin(String fin);
    void logOut();
}
