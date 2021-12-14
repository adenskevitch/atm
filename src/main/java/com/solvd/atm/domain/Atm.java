package com.solvd.atm.domain;

import java.util.Map;

public class Atm {

    private static Atm instance;

    private Long id;
    private String uniqueNumber;
    private Integer cash;
    private Address address;
    private Map<Integer, Integer> blrRubBanknotes;

    private Atm() {
    }

    public static Atm getInstance() {
        if (instance == null) {
            instance = new Atm();
        }
        return instance;
    }

    public static void setInstance(Atm atm) {
        instance = atm;
    }

    public void putBanknote(Integer denomination, Integer number) {
        this.blrRubBanknotes.put(denomination, number);
    }

    @Override
    public String toString() {
        return "Atm{" +
                "id=" + id +
                ", uniqueNumber='" + uniqueNumber + '\'' +
                ", cash=" + cash +
                ", blrRubBanknotes=" + blrRubBanknotes +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUniqueNumber() {
        return uniqueNumber;
    }

    public void setUniqueNumber(String uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

    public Integer getCash() {
        return cash;
    }

    public void setCash(Integer cash) {
        this.cash = cash;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Map<Integer, Integer> getBlrRubBanknotes() {
        return blrRubBanknotes;
    }

    public void setBlrRubBanknotes(Map<Integer, Integer> blrRubBanknotes) {
        this.blrRubBanknotes = blrRubBanknotes;
    }
}
