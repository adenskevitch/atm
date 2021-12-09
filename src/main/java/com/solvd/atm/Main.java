package com.solvd.atm;

import com.solvd.atm.domain.Account;
import com.solvd.atm.domain.Atm;
import com.solvd.atm.domain.Bank;
import com.solvd.atm.domain.Card;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Card card1 = new Card();
        card1.setCardNumber("4556211736980023");
        card1.setCardPin("1111");

        Card card2 = new Card();
        card2.setCardNumber("4532615872695329");
        card2.setCardPin("2222");

        Card card3 = new Card();
        card3.setCardNumber("4716609156586351");
        card3.setCardPin("3333");

        Card card4 = new Card();
        card4.setCardNumber("5219340690745977");
        card4.setCardPin("4444");

        Card card5 = new Card();
        card5.setCardNumber("5450723007391254");
        card5.setCardPin("5555");


        List<Card> cardList1 = new ArrayList<>();
        cardList1.add(card1);
        cardList1.add(card2);
        cardList1.add(card3);

        List<Card> cardList2 = new ArrayList<>();
        cardList2.add(card4);
        cardList2.add(card5);


        Atm atm1 = new Atm();
        atm1.setCash(10000);

        Atm atm2 = new Atm();
        atm2.setCash(1000);

        Atm atm3 = new Atm();
        atm1.setCash(10);


        List<Atm> atms = new ArrayList<>();
        atms.add(atm1);
        atms.add(atm2);
        atms.add(atm3);


        Account account1 = new Account();
        account1.setAccountNumber("123qwe456rty789uio");
        account1.setMoney(20000);
        account1.setLock_status(false); // in future may be changed to true by default
        account1.setCards(cardList1);

        Account account2 = new Account();
        account2.setAccountNumber("asd321fgh654jkl987");
        account2.setMoney(10);
        account2.setLock_status(true);
        account2.setCards(cardList2);


        List<Account> accountList1 = new ArrayList<>();
        accountList1.add(account1);
        accountList1.add(account2);


        Bank bank1 = new Bank();
        bank1.setName("MegaBank");
        bank1.setAtms(atms);
        bank1.setAccounts(accountList1);

    }
}
