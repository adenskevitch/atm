package com.solvd.atm.service.impl;

import com.solvd.atm.domain.Account;
import com.solvd.atm.domain.Atm;
import com.solvd.atm.domain.Card;
import com.solvd.atm.persistence.AtmRepository;
import com.solvd.atm.persistence.impl.AtmRepositoryImpl;
import com.solvd.atm.service.AccountService;
import com.solvd.atm.service.AtmService;
import com.solvd.atm.service.CardService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class AtmServiceImpl implements AtmService {

    private static final Logger LOGGER = LogManager.getLogger();

    private final AtmRepository atmRepository;
    private final AccountService accountService;
    private final CardService cardService;

    public AtmServiceImpl() {
        this.atmRepository = new AtmRepositoryImpl();
        this.accountService = new AccountServiceImpl();
        this.cardService = new CardServiceImpl();
    }

    @Override
    public Atm getAtmInfo(String uniqueNumber) {
        return atmRepository.getAtmInfo(uniqueNumber);
    }

    /*
        This method is basic for ATM application.
        It provide human interaction and include local methods for different operations and card validation.
         */
    @Override
    public void inputCard() {
        Card card;
        Scanner in;
        /*
        waiting for card input
         */
        while (true) {
            LOGGER.info("Please, enter card...");
            card = new Card();
            in = new Scanner(System.in);
            card.setNumber(in.nextLine());
            /*
            checking for a card on the server
             */
            if (accountService.getAccountInfo(card) == null) {
                LOGGER.info("Card reading error");
            } else {
                Account.setInstance(accountService.getAccountInfo(card));
                System.out.println(Account.getInstance());
                /*
                  Check PIN realisation...
                 */
                cardService.checkPin(card);
                card = cardService.getByNumber(card.getNumber());
                while (Account.getInstance().getNumber() != null && !card.getBlocked()) {
                    LOGGER.info("Select operation:\n1 - Cash withdrawal.\n2 - Return card.");
                    int selectNumber = in.nextInt();
                    switch (selectNumber) {
                        case 1: {
                            LOGGER.info("Enter the amount...");
                            Integer money = in.nextInt();
                            /*
                              Place for account money check
                             */
                            getMoney(Account.getInstance(), money);
                            LOGGER.info("Take the money...\nDo you want to continue?\n1 - Yes.\n2 - No.");
                            selectNumber = in.nextInt();
                            switch (selectNumber) {
                                case 1:
                                    break;
                                case 2: {
                                    LOGGER.info("Take the card...");
                                    finishWork(Account.getInstance());
                                    Account.setInstance(null);
                                }
                                break;
                                default:
                                    LOGGER.info("Input Error!");
                            }
                        }
                        break;
                        case 2: {
                            LOGGER.info("Take the card...");
                            finishWork(Account.getInstance());
                            Account.setInstance(null);
                        }
                        break;
                        default:
                            LOGGER.info("Input Error!");
                    }
                }
            }
        }
    }

    @Override
    public void getMoney(Account account, Integer money) {
        account.setMoney(account.getMoney() - money);
        accountService.decrementMoney(account, account.getMoney());
    }

    @Override
    public void finishWork(Account account) {
        if(account.getLockStatus() == null) {
            accountService.unlockAccount(account);
        }
    }

}
