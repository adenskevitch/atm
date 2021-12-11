package com.solvd.atm.service.impl;

import com.solvd.atm.domain.Account;
import com.solvd.atm.domain.Card;
import com.solvd.atm.persistence.AccountRepository;
import com.solvd.atm.persistence.impl.AccountRepositoryImpl;
import com.solvd.atm.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl() {

        this.accountRepository = new AccountRepositoryImpl();
    }

    @Override
    public Account getAccountInfo(Card cardNumber) {
        accountRepository.blockAccount(cardNumber);
        return accountRepository.getAccountInfo(cardNumber);
    }

    @Override
    public void decrementMoney(Account account, Integer money) {
        accountRepository.decrementAccountMoney(account, money);
    }

    @Override
    public void unlockAccount(Account account) {
        accountRepository.unblockAccount(account);
    }

}
