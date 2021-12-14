package com.solvd.atm.service;

import com.solvd.atm.domain.Account;
import com.solvd.atm.domain.Atm;

import java.util.List;
import java.util.Map;

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
    void getMoney(Account account, Integer money);

    /**
     * finish work with current account
     * aet accountLock to false
     * current account set null
     * current card set null
     */
    void finishWork(Account account);

    List<List<?>> moneyVariants(Map<Integer, Integer> cashInAtm, Integer requiredCash);

    void transferMoney(Account account, String cardNumber, Integer money);

    void continueWork();

}
