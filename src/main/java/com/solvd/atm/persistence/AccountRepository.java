package com.solvd.atm.persistence;

import org.apache.ibatis.annotations.Param;

public interface AccountRepository {

    //set account lock
    void blockAccount(Card card);

    Account getAccountInfo(Card cardInfo);

    /**
     * update account_money
     * update atm_cash
     */
    void decrementAccountMoney(@Param("account") Account account, @Param("money") Integer money);

    //set account unlock
    void unblockAccount(Card card);

}

