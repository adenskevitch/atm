package com.solvd.atm.persistence;

import com.solvd.atm.domain.Atm;
import com.solvd.atm.domain.Bank;

public interface AtmRepository {

    Atm getAtmInfo(String uniqueNumber);

    Bank getBankInfo(Atm atm);

}
