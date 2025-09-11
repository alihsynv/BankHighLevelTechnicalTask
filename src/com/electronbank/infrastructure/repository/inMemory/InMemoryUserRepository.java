package com.electronbank.infrastructure.repository.inMemory;

import com.electronbank.domain.entity.User;
import com.electronbank.infrastructure.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserRepository implements UserRepository {
    private List<User> users = new ArrayList<>();


    @Override
    public void save(User user) {

    }

    @Override
    public boolean findByFin(String fin) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }
}
