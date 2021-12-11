package com.solvd.atm.service;

import com.solvd.atm.domain.Account;
import com.solvd.atm.domain.Atm;

public interface AtmService {

    Atm getAtmInfo(String uniqueNumber);

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

    //
//    /**
//     * finish work with current account
//     * aet accountLock to false
//     * current account set null
//     * current card set null
//     */
    void finishWork(Account account);

}
