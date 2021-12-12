package com.solvd.atm.domain;

import java.util.Map;

public class Atm {

    private Long id;
    private String uniqueNumber;
    private Integer cash;
    private Map<Integer, Integer> blrRubBanknotes;

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

    public Map<Integer, Integer> getBlrRubBanknotes() {
        return blrRubBanknotes;
    }

    public void setBlrRubBanknotes(Map<Integer, Integer> blrRubBanknotes) {
        this.blrRubBanknotes = blrRubBanknotes;
    }
}
