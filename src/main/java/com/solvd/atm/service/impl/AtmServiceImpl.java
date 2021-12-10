package com.solvd.atm.service.impl;

import com.solvd.atm.domain.Account;
import com.solvd.atm.domain.Card;
import com.solvd.atm.service.AccountService;
import com.solvd.atm.service.AtmService;

public class AtmServiceImpl implements AtmService {
    //
//    private final AtmRepository atmRepositopy;
//    private final CardService cardService;
    private final AccountService accountService;

    //
    public AtmServiceImpl() {
//        this.atmRepository = new AtmRepositoryImpl();
//        this.cardService = new CardServiceImpl();
        this.accountService = new AccountServiceImpl();
    }

//    @Override
//    public Atm getAtmInfo(Atm atm) {
//        return null;
//    }

    //
    @Override
    public Account inputCard(Card userCard) {
        return accountService.getAccountInfo(userCard);
    }

    //
    @Override
    public void getMoney(Account account, Integer money) {
        account.setMoney(account.getMoney() - money);
        accountService.decrementMoney(account, account.getMoney());
    }

    @Override
    public void finishWork(Account account) {
        account.setLock_status(false);
        accountService.unlockAccount(account);
    }
}
