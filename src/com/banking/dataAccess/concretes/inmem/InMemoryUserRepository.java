package com.banking.dataAccess.concretes.inmem;

import com.banking.business.exceptions.UserNotFoundException;
import com.banking.dataAccess.abstarcts.UserRepository;
import com.banking.entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserRepository implements UserRepository {
    private final List<User> users = new ArrayList<>();


    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public boolean findByFin(String fin) {
        for (User user : users) {
            if (user.getFin().equals(fin)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public User getUserByFin(String fin) throws  UserNotFoundException {
        for (User user : users) {
            if (user.getFin().equals(fin)) {
                return user;
            }
        }
        throw new UserNotFoundException("İstifadəçi tapılmadı: " + fin);

    }

    @Override
    public List<User> findAll() throws  UserNotFoundException {
        for (User user : users) {
            return users;
        }
        throw new UserNotFoundException("Not found user");
    }
}
