package com.solvd.atm.service.impl;

import com.solvd.atm.domain.Account;
import com.solvd.atm.domain.Card;
import com.solvd.atm.service.AccountService;
import com.solvd.atm.service.AtmService;

import java.util.*;

public class AtmServiceImpl implements AtmService {
    //
//    private final AtmRepository atmRepositopy;
//    private final CardService cardService;
    private final AccountService accountService;

    //
    public AtmServiceImpl() {
//        this.atmRepository = new AtmRepositoryImpl();
//        this.cardService = new CardServiceImpl();
        this.accountService = new AccountServiceImpl();
    }

//    @Override
//    public Atm getAtmInfo(Atm atm) {
//        return null;
//    }

    //
    @Override
    public Account inputCard(Card userCard) {
        return accountService.getAccountInfo(userCard);
    }

    //
    @Override
    public void getMoney(Account account, Integer money) {
        account.setMoney(account.getMoney() - money);
        accountService.decrementMoney(account, account.getMoney());
    }

    @Override
    public void finishWork(Account account) {
        account.setLock_status(false);
        accountService.unlockAccount(account);
    }

    @Override
    public List<List<?>> moneyVariants(Map<Integer, Integer> cashInAtm, Integer requiredCash) {

        List<List<?>> listOfVariants = new ArrayList<>();

        Map<Integer, Integer> sumMap = new LinkedHashMap<>();
        cashInAtm.forEach((k, v) -> sumMap.put(k, requiredCash / k));
        System.out.println(sumMap);


        for (int n = 0; n < 6; n++) {

            Integer virtualCash = requiredCash;
            List<Integer> variant = new LinkedList<>();


            for (Map.Entry<Integer, Integer> entry : sumMap.entrySet()) {

                Integer banknote = virtualCash / entry.getKey();

                for (int i = 0; i < banknote & i < entry.getValue(); i++) {
                    variant.add(entry.getKey());
                    virtualCash = virtualCash - entry.getKey();
                }
                entry.setValue(entry.getValue() - 1);
            }
            if (!listOfVariants.contains(variant)) {
                listOfVariants.add(variant);
            }

        }
        listOfVariants.forEach(System.out::println);

        return null;
    }
}
