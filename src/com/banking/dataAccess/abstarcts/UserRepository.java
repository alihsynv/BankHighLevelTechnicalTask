package com.banking.dataAccess.abstarcts;

import com.banking.entities.concretes.User;

import java.util.List;

public interface UserRepository extends Repository<User, String> {
    void save(User user);

    void update(User user);

    void delete(String fin);

    boolean findByFin(String fin);

    User getUserByFin(String fin);

    List<User> findAll();
}
