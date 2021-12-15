package com.solvd.atm.persistence.impl;

import com.solvd.atm.domain.Banknote;
import com.solvd.atm.persistence.BanknoteRepository;
import com.solvd.atm.persistence.MyBatisSessionHolder;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BanknoteRepositoryImpl implements BanknoteRepository {

    @Override
    public List<Banknote> getBanknoteInfo(String atmNumber) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            return session.getMapper(BanknoteRepository.class).getBanknoteInfo(atmNumber);
        }
    }
}
