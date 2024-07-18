package com.bank.DB;

import com.bank.DTO.ru.cbr.ed.leaftypes.v2.RstrType;
import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "AccRstrList")
public class AccRstrListEntity {
    @Id
    @GeneratedValue
    private BigInteger id;

    @Column(name = "AccRstr", length = 4,nullable = false)
    private String AccRstr;

    @Column(name = "AccRstrDate",nullable = false)
    private Date AccRstrDate;

    @Column(name = "SuccessorBIC", length = 9, nullable = true)
    private String SuccessorBIC;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Account")
    private Accounts accounts;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AccRstrListEntity{" +
                "id=" + id +
                ", AccRstr='" + AccRstr + '\'' +
                ", AccRstrDate=" + AccRstrDate +
                ", SuccessorBIC='" + SuccessorBIC + '\'' +
                ", accounts=" + accounts +
                '}';
    }

    public String getAccRstr() {
        return AccRstr;
    }

    public void setAccRstr(String accRstr) {
        AccRstr = accRstr;
    }

    public Date getAccRstrDate() {
        return AccRstrDate;
    }

    public void setAccRstrDate(Date accRstrDate) {
        AccRstrDate = accRstrDate;
    }

    public String getSuccessorBIC() {
        return SuccessorBIC;
    }

    public void setSuccessorBIC(String successorBIC) {
        SuccessorBIC = successorBIC;
    }

    public Accounts getAccounts() {
        return accounts;
    }

    public void setAccounts(Accounts accounts) {
        this.accounts = accounts;
    }

}
