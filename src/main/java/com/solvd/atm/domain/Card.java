package com.solvd.atm.domain;

public class Card {

    private Long id;
    private String number;
    private String pin;

    @Override
    public String toString() {
        return "Card{" +
                "cardId=" + id +
                ", cardNumber='" + number + '\'' +
                ", cardPin='" + pin + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

}
