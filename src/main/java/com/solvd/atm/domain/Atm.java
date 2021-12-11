package com.solvd.atm.domain;

public class Atm {

    private Long id;
    private Integer cash;
    private String uniqueNumber;

    @Override
    public String toString() {
        return "Atm{" +
                "id=" + id +
                ", cash=" + cash +
                ", uniqueNumber='" + uniqueNumber + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCash() {
        return cash;
    }

    public void setCash(Integer cash) {
        this.cash = cash;
    }

    public String getUniqueNumber() {
        return uniqueNumber;
    }

    public void setUniqueNumber(String uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

}
