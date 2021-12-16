package com.solvd.atm.persistence;

import com.solvd.atm.domain.Atm;
import com.solvd.atm.domain.Bank;
import org.apache.ibatis.annotations.Param;

public interface AtmRepository {

    Atm getAtmInfo(String uniqueNumber);

    Bank getBankInfo(Atm atm);

    //void decrementAtmCash(@Param("atm") Atm atm, @Param("money") Integer money);

}
