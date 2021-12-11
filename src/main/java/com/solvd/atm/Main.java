package com.solvd.atm;

import com.solvd.atm.domain.Account;
import com.solvd.atm.domain.Atm;
import com.solvd.atm.service.AtmService;
import com.solvd.atm.service.impl.AtmServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;


public class Main {

    private static final Logger LOGGER = LogManager.getLogger();

    static {
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Input unique ATM number (ALFA001): ");
        String atmNumber = scanner.next();
        Atm atm = new AtmServiceImpl().getAtmInfo(atmNumber);
        LOGGER.info(atm);
    }

    public static void main(String[] args) {

        // card numbers to test
        // 4578091276840365     4567
        // 3456709774562548     9870
        // 8354546509264896     2545

        AtmService atmService = new AtmServiceImpl();
        atmService.inputCard();
        System.out.println(Account.getInstance());
    }

}
