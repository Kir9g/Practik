package com.bank.DB;

import com.bank.DTO.ru.cbr.ed.leaftypes.v2.ChangeType;
import com.bank.DTO.ru.cbr.ed.v2.AccountsType;
import com.bank.DTO.ru.cbr.ed.v2.SWBICList;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "BICDirectoryEntry")
public class BICDirectoryEntry {
    @Id
    @GeneratedValue
    private BigInteger id;

    @Column(name = "BIC", length = 9,nullable = false)
    private String BIC;

    @ManyToOne
    @JoinColumn(name = "ChangeTypeId")
    private ChangeTypeEntity changeType;

    @OneToOne(cascade = CascadeType.ALL)
    private ParticipantInfoEntity participantInfo;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Accounts> accounts = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<SWBICSEntity> swbics = new HashSet<>();

    @ManyToOne()
    @JoinColumn(name = "ED_id")
    private ED807Entity ed807Entity;

    public ED807Entity getEd807Entity() {
        return ed807Entity;
    }

    public void setEd807Entity(ED807Entity ed807Entity) {
        this.ed807Entity = ed807Entity;
    }

    public Set<SWBICSEntity> getSwbics() {
        return swbics;
    }

    public void setSwbics(Set<SWBICSEntity> swbics) {
        this.swbics = swbics;
    }
    public void addSwbics(SWBICSEntity swbics){
        this.swbics.add(swbics);
    }

    public Set<Accounts> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Accounts> accounts) {
        this.accounts = accounts;
    }
    public void addAccount(Accounts accounts) {
        this.accounts.add((Accounts) accounts);
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getBIC() {
        return BIC;
    }

    public void setBIC(String BIC) {
        this.BIC = BIC;
    }

    public ChangeTypeEntity getChangeType() {
        return changeType;
    }

    public void setChangeType(ChangeTypeEntity changeType) {
        this.changeType = changeType;
    }

    public ParticipantInfoEntity getParticipantInfo() {
        return participantInfo;
    }

    public void setParticipantInfo(ParticipantInfoEntity participantInfo) {
        this.participantInfo = participantInfo;
    }

    @Override
    public String toString() {
        return "BICDirectoryEntry{" +
                "id=" + id +
                ", BIC='" + BIC + '\'' +
                ", changeType=" + changeType +
                ", participantInfo=" + participantInfo +
                ", accounts=" + accounts +
                ", swbics=" + swbics +
                ", ed807Entity=" + ed807Entity +
                '}';
    }
}

