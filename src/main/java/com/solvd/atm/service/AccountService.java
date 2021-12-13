package com.solvd.atm.service;

import com.solvd.atm.domain.Account;
import com.solvd.atm.domain.Card;

public interface AccountService {

    Account getAccountInfo(Card cardNumber);

    void decrementMoney(Account account, Integer money);

    void unlockAccount(Account account);

    void lockAccount(Account account);

}
