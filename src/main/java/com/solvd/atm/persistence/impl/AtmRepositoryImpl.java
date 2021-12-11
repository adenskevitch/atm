package com.solvd.atm.persistence.impl;

import com.solvd.atm.domain.Atm;
import com.solvd.atm.persistence.AccountRepository;
import com.solvd.atm.persistence.AtmRepository;
import com.solvd.atm.persistence.MyBatisSessionHolder;
import org.apache.ibatis.session.SqlSession;

public class AtmRepositoryImpl implements AtmRepository {

    @Override
    public Atm getAtmInfo(String uniqueNumber) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            return session.getMapper(AtmRepository.class).getAtmInfo(uniqueNumber);
        }
    }

//    @Override
//    public void decrementAtmCash(Atm atm, Integer money) {
//        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
//            session.getMapper(AccountRepository.class).decrementAccountMoney(atm, money);
//        }
//    }
//
}
