package com.bank.DB;

import com.bank.DTO.ru.cbr.ed.leaftypes.v2.ChangeType;
import com.bank.DTO.ru.cbr.ed.v2.AccountsType;
import com.bank.DTO.ru.cbr.ed.v2.SWBICList;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "BICDirectoryEntry")
public class BICDirectoryEntry {
    @Id
    @GeneratedValue
    private BigInteger id;

    @Column(name = "BIC", length = 9,nullable = false)
    private String BIC;

    @Column(name = "ChangeType", length = 4, nullable = true)
    private String ChangeType;

    @OneToOne(cascade = CascadeType.ALL)
    private ParticipantInfoEntity participantInfo;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Accounts> accounts;

    @OneToMany(cascade = CascadeType.ALL)
    private List<SWBICSEntity> swbics;

    @ManyToOne()
    @JoinColumn(name = "ED_id")
    private ED807Entity ed807Entity;

    public ED807Entity getEd807Entity() {
        return ed807Entity;
    }

    public void setEd807Entity(ED807Entity ed807Entity) {
        this.ed807Entity = ed807Entity;
    }

    public List<SWBICSEntity> getSwbics() {
        return swbics;
    }

    public void setSwbics(List<SWBICSEntity> swbics) {
        this.swbics = swbics;
    }

    public List<Accounts> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Accounts> accounts) {
        this.accounts = accounts;
    }

    public ParticipantInfoEntity getParticipantInfo() {
        return participantInfo;
    }

    public void setParticipantInfo(ParticipantInfoEntity participantInfo) {
        this.participantInfo = participantInfo;
    }

    public String getChangeType() {
        return ChangeType;
    }

    public void setChangeType(String changeType) {
        ChangeType = changeType;
    }

    public String getBIC() {
        return BIC;
    }

    public void setBIC(String BIC) {
        this.BIC = BIC;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BICDirectoryEntry{" +
                "id=" + id +
                ", BIC='" + BIC + '\'' +
                ", ChangeType='" + ChangeType + '\'' +
                ", participantInfo=" + participantInfo +
                ", accounts=" + accounts +
                ", swbics=" + swbics +
                ", ed807Entity=" + ed807Entity +
                '}';
    }
}
