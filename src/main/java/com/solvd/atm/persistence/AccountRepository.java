package com.solvd.atm.persistence;

public interface AccountRepository {

    //set account lock
    void blockAccount(Card card);

    Account getAccountInfo(Card cardInfo);

    /**
     * update account_money
     * update atm_cash
     */
    void decrementMoney(Account account, Integer money);

    //set account unlock
    void unblockAccount(Card card);

}
