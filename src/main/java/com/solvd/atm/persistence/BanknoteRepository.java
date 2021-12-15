package com.solvd.atm.persistence;

import com.solvd.atm.domain.Banknote;

import java.util.List;

public interface BanknoteRepository {

    List<Banknote> getBanknoteInfo(String atmNumber);

}
