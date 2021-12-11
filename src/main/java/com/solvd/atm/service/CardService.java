package com.solvd.atm.service;

import com.solvd.atm.domain.Card;

public interface CardService {

    void checkPin(Card card);

    Card getByNumber(String cardNumber);

}
