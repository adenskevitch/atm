package com.solvd.atm.service.impl;

import com.solvd.atm.domain.Banknote;
import com.solvd.atm.persistence.BanknoteRepository;
import com.solvd.atm.persistence.impl.BanknoteRepositoryImpl;
import com.solvd.atm.service.BanknoteService;

import java.util.List;

public class BanknoteServiceImpl implements BanknoteService {

    private final BanknoteRepository banknoteRepository;

    public BanknoteServiceImpl() {
        this.banknoteRepository = new BanknoteRepositoryImpl();
    }

    @Override
    public List<Banknote> getBanknoteInfo(String atmNumber) {
        return banknoteRepository.getBanknoteInfo(atmNumber);
    }
}
