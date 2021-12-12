package com.solvd.atm.service;

import com.solvd.atm.domain.Banknote;

import java.util.List;

public interface BanknoteService {

    List<Banknote> getBanknoteInfo(String atmNumber);

}
