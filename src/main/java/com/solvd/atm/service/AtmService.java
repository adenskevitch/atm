package com.solvd.atm.service;

import com.solvd.atm.domain.Account;
import com.solvd.atm.domain.Atm;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;

public interface AtmService {

    /**
     * This method for initialisation atm's object.
     *
     * @param atmNumber get from config file.
     * @return if DB contain atm with atmNumber
     */
    Atm getAtmInfo(String atmNumber);

    /**
     * It is the basic method.
     * waiting for card input
     * block account
     * create local account object
     * an invitation to insert a card and checking the correctness of the PIN code
     * other operation will select in this method
     */
    void inputCard();

    /**
     * This method is basic for ATM application.
     * It provides human interaction and include local methods for different operations and card validation.
     * quantity of many
     *
     * @param money user input from keyboard
     */
    void getMoney(Account account, BigDecimal money);

    /**
     * finish work with current account
     * aet accountLock to false
     * current account set null
     * current card set null
     */
    void finishWork();

    /**
     * This method provides various options for sets of banknotes
     *
     * @param cashInAtm    - ATMs banknotes list
     * @param requiredCash - user input
     * @return - options for issuing banknotes
     */
    List<List<?>> moneyVariants(LinkedHashMap<Integer, Integer> cashInAtm, Integer requiredCash);

    /**
     * This method performs the function of transferring money
     *
     * @param account    - current user account
     * @param cardNumber - destination card number for transfer
     * @param money      - transfer amount
     */
    void transferMoney(Account account, String cardNumber, BigDecimal money);

    /**
     * This support method for checking the availability of the amount on the account
     *
     * @param money - amount for check
     * @return - true if the amount is in stock, or false if not.
     */
    boolean checkBalance(BigDecimal money);

    /**
     * This is support method for provide interactive with user
     */
    void continueWork();

    /**
     * This method calculate the commission depending on the current ATM
     *
     * @return - commission percent
     */
    Double findCommission(Account account, Atm atm);
}
