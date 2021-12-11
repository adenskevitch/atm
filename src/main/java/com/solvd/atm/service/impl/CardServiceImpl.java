package com.solvd.atm.service.impl;

import com.solvd.atm.domain.Card;
import com.solvd.atm.persistence.CardRepository;
import com.solvd.atm.persistence.impl.CardRepositoryImpl;
import com.solvd.atm.service.AccountService;
import com.solvd.atm.service.CardService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class CardServiceImpl implements CardService {

    private static final Logger LOGGER = LogManager.getLogger(CardService.class);

    private final CardRepository cardRepository = new CardRepositoryImpl();
    private final AccountService accountService = new AccountServiceImpl();

    private Boolean comparePin(Card card) {
        String pin = cardRepository.findByNumber(card.getNumber()).getPin();
        return card.getPin().equals(pin);
    }

    @Override
    public Card getByNumber(String cardNumber) {
        return cardRepository.findByNumber(cardNumber);
    }

    private void blockCard(Card card) {
        card.setBlocked(true);
        cardRepository.blockCard(card);
    }

    @Override
    public void checkPin(Card card) {
        Scanner in = new Scanner(System.in);
        for (int i = 1; i <= 3; i++) {
            LOGGER.info("Enter pin...");
            card.setPin(in.nextLine());
            if (comparePin(card)) {
                break;
            } else {
                if (i < 3) {
                    LOGGER.info("You entered wrong pin!");
                    LOGGER.info("Quantity of left attempts:  " + (3 - i));
                } else {
                    LOGGER.info("Your card is blocked");
                    blockCard(card);
                }
            }
        }
    }

}
