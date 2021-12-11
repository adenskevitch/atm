package com.solvd.atm.persistence;

import com.solvd.atm.domain.Card;

public interface CardRepository {

    void blockCard(Card card);

    Card findByNumber(String cardNumber);

}
