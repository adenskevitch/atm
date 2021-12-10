package com.solvd.atm.service;

import com.solvd.atm.domain.Account;
import com.solvd.atm.domain.Card;

import java.util.List;
import java.util.Map;

public interface AtmService {

//    Atm getAtmInfo(Atm atm);

    /**
     * card object from main
     * block account
     * create account object
     */

    Account inputCard(Card userCard);

    /**
     * operation select
     * quantity of many
     */
    void getMoney(Account account, Integer money);
//
//    /**
//     * finish work with current account
//     * aet accountLock to false
//     * current account set null
//     * current card set null
//     */
    void finishWork(Account account);

    public List<List<?>> moneyVariants(Map<Integer, Integer> cashInAtm, Integer requiredCash);

}
