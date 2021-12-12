package com.solvd.atm.service.impl;

import com.solvd.atm.domain.Account;
import com.solvd.atm.domain.Card;
import com.solvd.atm.service.AccountService;
import com.solvd.atm.service.AtmService;

import java.util.*;
import java.util.stream.Collectors;

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

        // list with lists of variants for user to select
        List<List<?>> listOfVariants = new ArrayList<>();

        // filling sumMap map with values
        // key -> banknote, value -> requiredCash / k (possible banknotes to give)
        Map<Integer, Integer> sumMap = new LinkedHashMap<>();

        cashInAtm.forEach((k, v) ->
        {
            if ((requiredCash / k) > v) {
                sumMap.put(k, v);
            } else {
                sumMap.put(k, requiredCash / k);
            }
        });

        System.out.println(sumMap);


        // number of variants for user to select
        for (int n = 0; n < 6; n++) {

            // variable to reset value of virtual required cash
            Integer virtualCash = requiredCash;
            // current variant of banknote set
            List<Integer> variant = new LinkedList<>();

            for (Map.Entry<Integer, Integer> entry : sumMap.entrySet()) {

                Integer banknote = virtualCash / entry.getKey();

                // loop for add banknotes with same value
                for (int i = 0; i < banknote & i < entry.getValue(); i++) {
                    variant.add(entry.getKey());
                    virtualCash = virtualCash - entry.getKey();
                }
            }

            // NOT add variant if it exists
            if (!listOfVariants.contains(variant)) {
                if (Objects.equals(variant.stream().reduce(0, Integer::sum), requiredCash)) {
                    listOfVariants.add(variant);
                }
            }

            for (Map.Entry<Integer, Integer> entry : sumMap.entrySet()) {
                if (entry.getValue() > 0) {
                    entry.setValue(entry.getValue() - 1);
                    break;
                }
            }


        }

//        listOfVariants.forEach(nestedList -> nestedList.forEach(nominal -> ));

        return listOfVariants;
    }
}
