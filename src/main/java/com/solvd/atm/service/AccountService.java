package com.solvd.atm.service;

import com.solvd.atm.domain.Account;
import com.solvd.atm.domain.Card;

public interface AccountService {

    Account getAccountInfo(Card cardInfo);

    void decrementMoney(Account account, Integer money);

}
