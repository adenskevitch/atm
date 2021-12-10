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

    public Long getCardId() {
        return id;
    }

    public void setCardId(Long cardId) {
        this.id = cardId;
    }

    public String getCardNumber() {
        return number;
    }

    public void setCardNumber(String cardNumber) {
        this.number = cardNumber;
    }

    public String getCardPin() {
        return pin;
    }

    public void setCardPin(String cardPin) {
        this.pin = cardPin;
    }

}
