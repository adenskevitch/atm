package com.solvd.atm.domain;

import java.util.List;

public class Account {

    private Long id;
    private String accountNumber;
    private Integer money;
    private List<Card> cards;
    private Boolean lock_status;

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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
        return lock_status;
    }

    public void setLock_status(Boolean lock_status) {
        this.lock_status = lock_status;
    }

}
