package com.solvd.atm.service.impl;

import com.solvd.atm.domain.Account;
import com.solvd.atm.domain.Atm;
import com.solvd.atm.domain.Bank;
import com.solvd.atm.domain.Card;
import com.solvd.atm.domain.exception.InvalidDataException;
import com.solvd.atm.persistence.AtmRepository;
import com.solvd.atm.persistence.impl.AtmRepositoryImpl;
import com.solvd.atm.service.AccountService;
import com.solvd.atm.service.AtmService;
import com.solvd.atm.service.BanknoteService;
import com.solvd.atm.service.CardService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.Scanner;

import java.util.*;
import java.util.stream.IntStream;

public class AtmServiceImpl implements AtmService {

    private static final Logger LOGGER = LogManager.getLogger();

    private final AtmRepository atmRepository;
    private final AccountService accountService;
    private final CardService cardService;
    private final BanknoteService banknoteService;

    public AtmServiceImpl() {
        this.atmRepository = new AtmRepositoryImpl();
        this.accountService = new AccountServiceImpl();
        this.cardService = new CardServiceImpl();
        this.banknoteService = new BanknoteServiceImpl();
    }

    @Override
    public Atm getAtmInfo(String uniqueNumber) {
        try {
            if (atmRepository.getAtmInfo(uniqueNumber) != null) {
                Atm atm = atmRepository.getAtmInfo(uniqueNumber);
                atm.setBlrRubBanknotes(new LinkedHashMap<>());
                atm.setCash(0);
                banknoteService.getBanknoteInfo(uniqueNumber).forEach(banknote -> {
                    atm.putBanknote(banknote.getBanknoteDenomination(), banknote.getBanknotesNumber());
                    atm.setCash(atm.getCash() + banknote.getBanknoteDenomination() * banknote.getBanknotesNumber());
                });
                return atm;
            } else throw new InvalidDataException("ATM not found.");
        } catch (InvalidDataException e) {
            LOGGER.info(e);
            return null;
        }
    }

    /*

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
            card.setNumber(cardService.encryptSha256(in.nextLine()));
            /*
            checking for a card on the server
             */
            if (accountService.getAccountInfo(card) != null) {
                Account.setInstance(accountService.getAccountInfo(card));
                System.out.println(Account.getInstance());
                /*
                  Check PIN realisation...
                 */
                cardService.checkPin(card);
                card = cardService.getByNumber(card.getNumber());
                while (Account.getInstance().getNumber() != null && !card.getBlocked()) {
                    LOGGER.info("Select operation:\n1 - Cash withdrawal.\n2 - Money transfer. \n3 - View account balance. \n4 - Return card.");
                    int selectNumber = in.nextInt();
                    switch (selectNumber) {
                        case 1: {
                            LOGGER.info("Enter the amount...");
                            BigDecimal money = new BigDecimal(in.next());
                            /*
                              Place for account money check
                             */
                            getMoney(Account.getInstance(), money);
                        }
                        break;
                        case 2: {
                            LOGGER.info("Enter number of destination card...");
                            in = new Scanner(System.in);
                            String cardNumber = in.nextLine();
                            //check of card input (exception)
                            try {
                                if (accountService.getAccountInfo(new Card(cardService.encryptSha256(cardNumber))) != null) {
                                    LOGGER.info("Enter the amount...");
                                    in = new Scanner(System.in);
                                    BigDecimal money = new BigDecimal(in.next());
                                    transferMoney(Account.getInstance(), cardNumber, money);
                                } else throw new InvalidDataException("Check if entered card number is correctly!");
                            } catch (InvalidDataException e) {
                                LOGGER.info(e);
                            }
                            break;
                        }
                        case 3: {
                            BigDecimal money = accountService.getBalance(card);
                            LOGGER.info("Your account balance is: " + money);
                            continueWork();
                            break;
                        }
                        case 4: {
                            finishWork();
                        }
                        break;
                        default:
                            try {
                                throw new InvalidDataException("Input Error!");
                            } catch (InvalidDataException e) {
                                LOGGER.info(e);
                            }
                    }
                }
            } else {
                try {
                    throw new InvalidDataException("Card read error...  ");
                } catch (InvalidDataException e) {
                    LOGGER.info(e);
                }
            }
        }
    }

    @Override
    public void continueWork() {
        Scanner in = new Scanner(System.in);
        LOGGER.info("Do you want to continue?\n1 - Yes.\n2 - No.");
        int selectNumber = in.nextInt();
        switch (selectNumber) {
            case 1:
                break;
            case 2:
                finishWork();
                break;
            default:
                try {
                    throw new InvalidDataException("Input Error!");
                } catch (InvalidDataException e) {
                    LOGGER.info(e);
                }
        }
    }

    @Override
    public boolean checkBalance(BigDecimal money) {
        int result = accountService.getBalance(Account.getInstance().getCard()).compareTo(money);
        return result == 1 || result == 0;
    }

    private void moneyWithdrawal(Integer intMoney) {
        Scanner in = new Scanner(System.in);
        List<List<?>> banknotesVariants = moneyVariants(Atm.getInstance().getBlrRubBanknotes(), intMoney);
        LOGGER.info("Select banknotes...\n");
        IntStream.range(0, banknotesVariants.size())
                .mapToObj(i -> (i + 1) + "\t" + banknotesVariants.get(i) + "\n")
                .forEach(LOGGER::info);
        List<?> resultVariant = banknotesVariants.get(in.nextInt() - 1);
        LOGGER.info(Atm.getInstance().getBlrRubBanknotes());
        IntStream.range(0, Atm.getInstance().getBlrRubBanknotes().size())
                .forEach(i -> resultVariant.stream()
                        .filter(o -> Atm.getInstance().getBlrRubBanknotes().keySet().toArray()[i].equals(o))
                        .forEach(o -> Atm.getInstance().getBlrRubBanknotes().put((Integer) Atm.getInstance().getBlrRubBanknotes().keySet().toArray()[i],
                                (Atm.getInstance().getBlrRubBanknotes().get((Integer) Atm.getInstance().getBlrRubBanknotes().keySet().toArray()[i]) - 1))));
        LOGGER.info(Atm.getInstance().getBlrRubBanknotes());
    }

    @Override
    public void getMoney(Account account, BigDecimal money) {
        try {
            if (checkBalance(money)) {
                Scanner in = new Scanner(System.in);
                Integer intMoney = money.intValue();
                double commission = findCommission();
                int selectNumber = useCommission(commission);
                commission = commission / 100;
                BigDecimal commissionSum = money.multiply(BigDecimal.valueOf(commission));
                switch (selectNumber) {
                    case 1: {
                        if (checkBalance(money.add(commissionSum))) {
                            moneyWithdrawal(intMoney);
                            BigDecimal fullAmount = money.add(commissionSum);
                            accountService.decrementMoney(account, fullAmount);
                            LOGGER.info("Take the money...");
                        } else {
                            throw new InvalidDataException("You don't have enough money to pay commission");
                        }
                        continueWork();
                        break;
                    }
                    case 2: {
                        continueWork();
                    }
                    default: {
                        try {
                            throw new InvalidDataException("Input Error!");
                        } catch (InvalidDataException e) {
                            LOGGER.info(e);
                        }
                    }
                }
            } else throw new InvalidDataException("Insufficient funds!");
        } catch (InvalidDataException e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void finishWork() {
        LOGGER.info("Take the card...");
        Account.setInstance(null);
        accountService.unlockAccount(Account.getInstance());
    }

    @Override
    public Double findCommission() {
        Bank bank = Account.getInstance().getBank();
        Bank atmBank = Atm.getInstance().getBank();
        if (!bank.getId().equals(atmBank.getId())) {
            return atmBank.getCommission();
        } else {
            return 0.0;
        }
    }

    private int useCommission(double commission) {
        Scanner in = new Scanner(System.in);
        int number;
        if (commission != 0.0) {
            LOGGER.info("Operation will cost " + commission + "%");
            LOGGER.info("\n1 - Continue.\n2 - Cancel.");
            number = in.nextInt();
        } else {
            number = 1;
        }
        return number;
    }

    @Override
    public void transferMoney(Account account, String cardNumber, BigDecimal money) {
        Account destinationAccount = accountService.getAccountInfo(cardService.getByNumber(cardService.encryptSha256(cardNumber)));
        //check of account money on account
        try {
            if (checkBalance(money)) {
                double commission = findCommission();
                int selectNumber = useCommission(commission);
                commission = commission / 100;
                BigDecimal commissionSum = money.multiply(BigDecimal.valueOf(commission));
                switch (selectNumber) {
                    case 1: {
                        if (checkBalance(money.add(commissionSum))) {
                            BigDecimal fullAmount = money.add(commissionSum);
                            accountService.decrementMoney(account, fullAmount);
                            accountService.incrementMoney(destinationAccount, money);
                            LOGGER.info("Your transaction was successful");
                        } else throw new InvalidDataException("You don't have enough money to pay commission");
                        continueWork();
                        break;
                    }
                    case 2: {
                        continueWork();
                        break;
                    }
                    default: {
                        try {
                            throw new InvalidDataException("Input Error!");
                        } catch (InvalidDataException e) {
                            LOGGER.info(e);
                        }
                    }
                }
            } else throw new InvalidDataException("Insufficient funds.");
        } catch (InvalidDataException e) {
            LOGGER.info(e);
        }
    }

    @Override
    public List<List<?>> moneyVariants(LinkedHashMap<Integer, Integer> cashInAtm, Integer requiredCash) {
        // list with lists of variants for user to select
        List<List<?>> listOfVariants = new ArrayList<>();
        // filling sumMap map with values
        // key -> banknote, value -> requiredCash / k (possible banknotes to give)
        Map<Integer, Integer> sumMap = new LinkedHashMap<>();
        cashInAtm.forEach((k, v) ->
        {
            if ((requiredCash / k) > v) {
                sumMap.put(k, v);
            } else {
                sumMap.put(k, requiredCash / k);
            }
        });
        System.out.println(sumMap);
        // number of variants for user to select
        for (int n = 0; n < 6; n++) {
            // variable to reset value of virtual required cash
            Integer virtualCash = requiredCash;
            // current variant of banknote set
            List<Integer> variant = new LinkedList<>();
            for (Map.Entry<Integer, Integer> entry : sumMap.entrySet()) {
                Integer banknote = virtualCash / entry.getKey();
                // loop for add banknotes with same value
                for (int i = 0; i < banknote & i < entry.getValue(); i++) {
                    variant.add(entry.getKey());
                    virtualCash = virtualCash - entry.getKey();
                }
            }
            // NOT add variant if it exists
            if (!listOfVariants.contains(variant)) {
                if (Objects.equals(variant.stream().reduce(0, Integer::sum), requiredCash)) {
                    listOfVariants.add(variant);
                }
            }
            for (Map.Entry<Integer, Integer> entry : sumMap.entrySet()) {
                if (entry.getValue() > 0) {
                    entry.setValue(entry.getValue() - 1);
                    break;
                }
            }
        }
//        listOfVariants.forEach(nestedList -> nestedList.forEach(nominal -> ));
        return listOfVariants;
    }
}
