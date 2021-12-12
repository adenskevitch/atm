package com.solvd.atm;

import com.solvd.atm.domain.Account;
import com.solvd.atm.domain.Atm;
import com.solvd.atm.domain.Card;
import com.solvd.atm.service.AtmService;
import com.solvd.atm.service.impl.AtmServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
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
//        Card card = new Card();
//        card.setCardNumber("4578091276840365");
//        card.setCardPin("4567");
//
//        Atm atm = new Atm();
//
        AtmService atmService = new AtmServiceImpl();
////        atm = atmService.getAtmInfo(atm);
//        Account account;
//        account = atmService.inputCard(card);
//        atmService.getMoney(account, 500);
//        atmService.finishWork(account);
//        System.out.println(account);

        // map of cash in atm cell
        // with key -> banknote, value -> quantity
        Map<Integer, Integer> cashMap = new LinkedHashMap<>();
        cashMap.put(200, 5);
        cashMap.put(100, 5);
        cashMap.put(50, 5);
        cashMap.put(20, 5);
        cashMap.put(10, 5);
        cashMap.put(5, 5);
        atmService.moneyVariants(cashMap, 115).forEach(System.out::println);

    }
}
