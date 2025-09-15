package com.banking.entities.concretes;

import java.time.LocalDate;

public class User {
    private String fin;
    private String password;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private Phone phone;

    public User(String fin, String password, String name, String surname, LocalDate dateOfBirth, Phone phone) {
        this.fin = fin;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
    }

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

    @Override
    public String toString() {
//        return "User{" +
//                "fin='" + fin + '\'' +
//                ", name='" + name + '\'' +
//                ", surname='" + surname + '\'' +
//                ", phone=" + phone +
//                '}';
        return "\n" + "Ad: " + name + "\n" + "Soyad: " + surname + "\n" + "FIN: " + fin + "\n";
    }
}
