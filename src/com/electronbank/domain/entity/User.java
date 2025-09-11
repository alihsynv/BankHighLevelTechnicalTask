package com.electronbank.domain.entity;

import com.electronbank.domain.value.Phone;

import java.time.LocalDate;

public class User {
    private String fin;
    private String password;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private Phone phone;

    public String getFin() {
        return fin;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Phone getPhone() {
        return phone;
    }
}
