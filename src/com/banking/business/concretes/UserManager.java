package com.banking.business.concretes;

import com.banking.business.abstracts.UserService;
import com.banking.core.exceptions.BaseException;
import com.banking.entities.concretes.User;
import com.banking.business.exceptions.InvalidLoginException;
import com.banking.business.exceptions.UserNotFoundException;
import com.banking.entities.concretes.Phone;
import com.banking.dataAccess.abstarcts.UserRepository;
import com.banking.business.validationRules.UserValidator;

import java.time.LocalDate;
import java.util.List;

public class UserManager implements UserService {
    private final UserRepository userRepository;
    private User user;

    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(String fin, String password, String name, String surname, LocalDate dateOfBirth, String providerCode, String number) throws BaseException {
        Phone phone = Phone.create(providerCode, number);
        User newUser = new User(fin, password, name, surname, dateOfBirth, phone);

        UserValidator.validateFullName(newUser.getName(), newUser.getSurname());
        UserValidator.validateFin(newUser.getFin());
        UserValidator.validateDate(newUser.getDateOfBirth());
        UserValidator.validatePassword(newUser.getPassword());
        userRepository.save(newUser);
    }


    @Override
    public User login(String fin, String password) throws InvalidLoginException {
        if (!userRepository.findByFin(fin)) {
            throw new InvalidLoginException("İstifadəçi tapılmadı. Qeydiyyatdan keçin!");
        }
        if (!userRepository.getUserByFin(fin).getPassword().equals(password)) {
            throw new InvalidLoginException("Şifrə səhvdir!");
        }
        return user;
    }

    @Override
    public User showUserByFin(String fin) throws UserNotFoundException {
        for (User user : userRepository.findAll()) {
            if (user.getFin().equals(fin)) {
                return user;
            }
        }
        throw new UserNotFoundException("İstifadəçi tapılmadı");
    }

    @Override
    public void logOut() throws UserNotFoundException {
        if (this.user != null) {
            this.user = null;
            System.out.println("Hesabdan çıxış edildi.");
        } else {
            throw new UserNotFoundException("Heç bir istifadəçi daxil olmayıb.");
        }
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
