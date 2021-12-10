package com.solvd.atm.domain;

import java.util.List;

public class Account {

    private Long id;
    private String number;
    private Integer money;
    private List<Card> cards;
    private Boolean lockStatus;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber='" + number + '\'' +
                ", money=" + money +
                ", cards=" + cards +
                ", lock_status=" + lockStatus +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return number;
    }

    public void setAccountNumber(String accountNumber) {
        this.number = accountNumber;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Boolean getLock_status() {
        return lockStatus;
    }

    public void setLock_status(Boolean lock_status) {
        this.lockStatus = lock_status;
    }

}
