package com.solvd.atm.service;

import com.solvd.atm.domain.Card;

public interface CardService {

    String encryptSha256 (String stringToEncrypt);

    void checkPin(Card card);

    Card getByNumber(String cardNumber);

}
