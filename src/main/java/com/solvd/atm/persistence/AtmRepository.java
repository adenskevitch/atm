package com.solvd.atm.persistence;

import com.solvd.atm.domain.Atm;

public interface AtmRepository {

    Atm getAtmInfo(String uniqueNumber);

}
