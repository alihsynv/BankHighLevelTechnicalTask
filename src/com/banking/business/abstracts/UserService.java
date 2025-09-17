package com.banking.business.abstracts;

import com.banking.entities.concretes.User;

public interface UserService {
    User login(String fin, String password);

    User showUserByFin(String fin);

    void logOut();
}
