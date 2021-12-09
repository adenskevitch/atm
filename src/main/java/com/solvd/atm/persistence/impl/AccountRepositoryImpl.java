package com.solvd.atm.persistence.impl;

import com.solvd.atm.persistence.AccountRepository;
import com.solvd.atm.persistence.MyBatisSessionHolder;
import org.apache.ibatis.session.SqlSession;

public class AccountRepositoryImpl implements AccountRepository {

    @Override
    public void blockAccount(Card card) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            session.getMapper(AccountRepository.class).blockAccount(card);
        }
    }

    @Override
    public Account getAccountInfo(Card cardInfo) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            return session.getMapper(AccountRepository.class).getAccountInfo(cardInfo);
        }
    }

    @Override
    public void decrementAccountMoney(Account account, Integer money) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            session.getMapper(AccountRepository.class).decrementAccountMoney(account, money);
        }
    }

    @Override
    public void unblockAccount(Card card) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            session.getMapper(AccountRepository.class).unblockAccount(card);
        }
    }
}
