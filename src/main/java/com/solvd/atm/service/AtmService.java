package com.solvd.atm.service;

import com.solvd.atm.domain.Account;
import com.solvd.atm.domain.Atm;
import com.solvd.atm.domain.Bank;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;

public interface AtmService {

    /**
     * This method for initialisation atm's object.
     * @param atmNumber get from config file.
     * @return if DB contain atm with atmNumber
     */
    Atm getAtmInfo(String atmNumber);

    /**
     * block account
     * create local account object
     * an invitation to insert a card and checking the correctness of the PIN code
     * other operation will select in this method
     */
    void inputCard();

    /**
     * quantity of many
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

    List<List<?>> moneyVariants(LinkedHashMap<Integer, Integer> cashInAtm, Integer requiredCash);

    void transferMoney(Account account, String cardNumber, BigDecimal money);

    void continueWork();

    boolean checkBalance(BigDecimal money);

    Double findCommission(Account account, Atm atm);
}
