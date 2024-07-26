package com.bank.DTO.Models;

import jakarta.persistence.Column;

import java.math.BigInteger;
import java.util.Date;

public class InitialEDDTO {
    private BigInteger ID;


    private BigInteger EDNo;


    private Date EDDate;


    private String EDAuthor;

    @Override
    public String toString() {
        return "InitialEDDTO{" +
                "ID=" + ID +
                ", EDNo=" + EDNo +
                ", EDDate=" + EDDate +
                ", EDAuthor='" + EDAuthor + '\'' +
                '}';
    }

    public BigInteger getID() {
        return ID;
    }

    public void setID(BigInteger ID) {
        this.ID = ID;
    }

    public BigInteger getEDNo() {
        return EDNo;
    }

    public void setEDNo(BigInteger EDNo) {
        this.EDNo = EDNo;
    }

    public Date getEDDate() {
        return EDDate;
    }

    public void setEDDate(Date EDDate) {
        this.EDDate = EDDate;
    }

    public String getEDAuthor() {
        return EDAuthor;
    }

    public void setEDAuthor(String EDAuthor) {
        this.EDAuthor = EDAuthor;
    }
}
