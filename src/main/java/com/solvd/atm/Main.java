package com.solvd.atm;

import com.solvd.atm.domain.Account;
import com.solvd.atm.domain.Atm;
import com.solvd.atm.domain.Card;
import com.solvd.atm.service.AtmService;
import com.solvd.atm.service.impl.AtmServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {

        // card numbers to test
        // 4578091276840365     4567
        // 3456709774562548     9870
        // 8354546509264896     2545

        // Creating Scanner object to read from input
        //Scanner scanner = new Scanner(System.in);

        // Creating card and set it value to null
        Card card = new Card();
        card.setCardNumber("4578091276840365");
        card.setCardPin("4567");

        Atm atm = new Atm();

        AtmService atmService = new AtmServiceImpl();
//        atm = atmService.getAtmInfo(atm);
        Account account;
        account = atmService.inputCard(card);
        atmService.getMoney(account, 500);
        atmService.finishWork(account);
        System.out.println(account);

        // Creating loop while user input valid data from DB
//        while(insertedCard == null) {
//            System.out.print("Input card number: ");
//            String cardNumber = scanner.next();
//
//            // Searching in DB by inputted card number
//            CardService cardService = new CardServiceImpl();
//            insertedCard = cardService.cardData(cardNumber);
//
//            // If inputted card number not found in DB -> print message
//            if (insertedCard == null) {
//                System.out.println("Ivalid card number. Please try again.");
//            }
//
//        }
    }
}
