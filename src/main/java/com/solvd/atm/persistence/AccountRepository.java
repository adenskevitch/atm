package com.solvd.atm.persistence;

import com.solvd.atm.domain.Account;
import com.solvd.atm.domain.Bank;
import com.solvd.atm.domain.Card;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface AccountRepository {

    //    set account lock
    void blockAccount(Account account);

    Account getAccountInfo(Card card);

    /*
     * update account_money
     * update atm_cash
     */
    void changeAccountMoney(@Param("account") Account account, @Param("money") BigDecimal money);

    //    set account unlock
    void unblockAccount(Account account);

    Bank getBankInfo(Account account);

}

