package com.bank.DB;

import jakarta.persistence.*;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "InitialED")
public class InitialED {
    @Id
    @GeneratedValue
    private Long ID;
    @Column(name = "EDNo", nullable = false, length = 9)
    private BigInteger EDNo;

    @Column(name = "EDDate",nullable = false)
    private Date EDDate;


    @Column(name = "EDAuthor", unique = true, length = 10,nullable = false)
    private String EDAuthor;

    @OneToOne()
    @JoinColumn(name = "ed807Entity")
    private ED807Entity ed807Entity;

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

    @Override
    public String toString() {
        return "InitialED{" +
                "EDNo=" + EDNo +
                ", EDDate=" + EDDate +
                ", EDAuthor='" + EDAuthor + '\'' +
                '}';
    }
}
