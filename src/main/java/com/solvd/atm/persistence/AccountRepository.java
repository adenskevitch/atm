package com.solvd.atm.persistence;

import com.solvd.atm.domain.Account;
import com.solvd.atm.domain.Card;
import org.apache.ibatis.annotations.Param;

public interface AccountRepository {

    //    set account lock
    void blockAccount(Account account);

    Account getAccountInfo(Card card);

    /*
     * update account_money
     * update atm_cash
     */
    void decrementAccountMoney(@Param("account") Account account, @Param("money") Integer money);

    //    set account unlock
    void unblockAccount(Account account);

}

