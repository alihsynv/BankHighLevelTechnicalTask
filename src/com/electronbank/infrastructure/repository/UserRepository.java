package com.electronbank.infrastructure.repository;

import com.electronbank.domain.entity.User;

import java.util.List;

public interface UserRepository {
    void save(User user);
    boolean findByFin(String fin);
    User getUserByFin(String fin);
    List<User> findAll();
}
