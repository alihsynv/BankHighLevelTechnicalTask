package com.banking.dataAccess.concretes.inmem;

import com.banking.entities.concretes.User;
import com.banking.business.exceptions.UserNotFoundException;
import com.banking.dataAccess.abstarcts.UserRepository;

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
    public User getUserByFin(String fin) {
        for (User user : users) {
            if (user.getFin().equals(fin)) {
                return user;
            }
        }
        throw new UserNotFoundException("İstifadəçi tapılmadı: " + fin);

    }

    @Override
    public List<User> findAll() {
        for (User user : users) {
//            System.out.println("Ad: " + user.getName() + "\n" + "Soyad: " + user.getSurname() + "\n" + "FIN: " + user.getFin());
//            System.out.println();
            return users;
        }
        throw new UserNotFoundException("Not found user");
    }
}
