package com.solvd.atm.service;

import com.solvd.atm.domain.Account;
import com.solvd.atm.domain.Atm;
import com.solvd.atm.domain.Bank;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;

public interface AtmService {

    Atm getAtmInfo(String atmNumber);

    /**
     * card object from main
     * block account
     * create account object
     */

    void inputCard();

    /**
     * operation select
     * quantity of many
     */
    void getMoney(Account account, BigDecimal money);

    /**
     * finish work with current account
     * aet accountLock to false
     * current account set null
     * current card set null
     */
    void finishWork(Account account);

    List<List<?>> moneyVariants(LinkedHashMap<Integer, Integer> cashInAtm, Integer requiredCash);

    void transferMoney(Account account, String cardNumber, BigDecimal money);

    void continueWork();

    boolean checkBalance(BigDecimal money);

    Double findCommission(Account account, Atm atm);
}
