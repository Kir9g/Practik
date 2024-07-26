package com.bank.DTO.Models;

import com.bank.DTO.ru.cbr.ed.leaftypes.v2.RstrType;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.math.BigInteger;
import java.util.Date;

public class RstrListDTO {
    private BigInteger id;


    private RstrType Rstr;

    @Temporal(TemporalType.DATE)
    private Date RstrDate;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public RstrType getRstr() {
        return Rstr;
    }

    public void setRstr(RstrType rstr) {
        Rstr = rstr;
    }

    public Date getRstrDate() {
        return RstrDate;
    }

    public void setRstrDate(Date rstrDate) {
        RstrDate = rstrDate;
    }

    @Override
    public String toString() {
        return "RstrListDTO{" +
                "id=" + id +
                ", Rstr=" + Rstr +
                ", RstrDate=" + RstrDate +
                '}';
    }
}
