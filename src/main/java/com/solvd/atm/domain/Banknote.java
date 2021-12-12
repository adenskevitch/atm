package com.solvd.atm.domain;

public class Banknote {

    private Long id;
    private Integer banknoteDenomination;
    private Integer banknotesNumber;
    private String currencyUnit;

    @Override
    public String toString() {
        return "Banknote{" +
                "id=" + id +
                ", banknoteDenomination=" + banknoteDenomination +
                ", banknotesNumber=" + banknotesNumber +
                ", currencyUnit='" + currencyUnit + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBanknoteDenomination() {
        return banknoteDenomination;
    }

    public void setBanknoteDenomination(Integer banknoteDenomination) {
        this.banknoteDenomination = banknoteDenomination;
    }

    public Integer getBanknotesNumber() {
        return banknotesNumber;
    }

    public void setBanknotesNumber(Integer banknotesNumber) {
        this.banknotesNumber = banknotesNumber;
    }

    public String getCurrencyUnit() {
        return currencyUnit;
    }

    public void setCurrencyUnit(String currencyUnit) {
        this.currencyUnit = currencyUnit;
    }
}