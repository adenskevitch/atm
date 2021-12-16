package com.solvd.atm.service;

import com.solvd.atm.domain.Account;
import com.solvd.atm.domain.Bank;
import com.solvd.atm.domain.Card;

import java.math.BigDecimal;

public interface AccountService {

    Account getAccountInfo(Card cardNumber);

    void decrementMoney(Account account, BigDecimal money);

    void unlockAccount(Account account);

    void lockAccount(Account account);

    void incrementMoney(Account account, BigDecimal money);

    BigDecimal getBalance(Card card);

    Bank getBank(Account account);

}
