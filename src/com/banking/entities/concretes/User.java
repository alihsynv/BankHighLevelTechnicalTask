package com.banking.entities.concretes;

import com.banking.entities.abstarcts.BaseEntity;

import javax.smartcardio.Card;
import java.time.LocalDate;
import java.util.List;

public class User implements BaseEntity {
    private final String fin;
    private final String password;
    private final String name;
    private final String surname;
    private final LocalDate dateOfBirth;
    private final Phone phone;
    private List<Card> cards;

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

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "\n" + "Ad: " + name + "\n" + "Soyad: " + surname + "\n" + "FIN: " + fin + "\n";
    }
}
