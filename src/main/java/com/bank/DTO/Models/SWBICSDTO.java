package com.bank.DTO.Models;

import jakarta.persistence.Column;

import java.math.BigInteger;

public class SWBICSDTO {
    private BigInteger Id;

    private String SWBIC;


    private Boolean DefaultSWBIC;

    @Override
    public String toString() {
        return "SWBICSDTO{" +
                "Id=" + Id +
                ", SWBIC='" + SWBIC + '\'' +
                ", DefaultSWBIC=" + DefaultSWBIC +
                '}';
    }

    public BigInteger getId() {
        return Id;
    }

    public void setId(BigInteger id) {
        Id = id;
    }

    public String getSWBIC() {
        return SWBIC;
    }

    public void setSWBIC(String SWBIC) {
        this.SWBIC = SWBIC;
    }

    public Boolean getDefaultSWBIC() {
        return DefaultSWBIC;
    }

    public void setDefaultSWBIC(Boolean defaultSWBIC) {
        DefaultSWBIC = defaultSWBIC;
    }
}
