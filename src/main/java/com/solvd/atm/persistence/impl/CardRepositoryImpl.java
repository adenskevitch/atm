package com.solvd.atm.persistence.impl;

import com.solvd.atm.domain.Card;
import com.solvd.atm.persistence.CardRepository;
import com.solvd.atm.persistence.MyBatisSessionHolder;
import org.apache.ibatis.session.SqlSession;

public class CardRepositoryImpl implements CardRepository {

    @Override
    public Card findByNumber(String cardNumber) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            return session.getMapper(CardRepository.class).findByNumber(cardNumber);
        }
    }

    @Override
    public void blockCard(Card card) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            session.getMapper(CardRepository.class).blockCard(card);
        }
    }
}
