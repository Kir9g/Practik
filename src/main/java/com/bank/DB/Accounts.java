package com.bank.DB;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.*;

@Entity
@Table(name = "Accounts")
public class Accounts {

    @Id
    @GeneratedValue
    private BigInteger id;

    @Column(name = "Account", nullable = false)
    private String Account;

    @Column(name = "RegulationAccountType", length = 4, nullable = false)
    private String regulationAccountType;

    @Column(name = "CK", length = 2)
    private String ck;

    @Column(name = "AccountCBRBIC", nullable = false, length = 9)
    private String accountCBRBIC;

    @Column(name = "DateIn", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateIn;

    @Column(name = "DateOut")
    @Temporal(TemporalType.DATE)
    private Date dateOut;

    @Column(name = "accountStatus", length = 4)
    private String accountStatus;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<AccRstrListEntity> accRstrListEntity = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BIC")
    private BICDirectoryEntry bicDirectoryEntry;

    @Override
    public String toString() {
        return "Accounts{" +
                "id=" + id +
                ", Account='" + Account + '\'' +
                ", regulationAccountType='" + regulationAccountType + '\'' +
                ", ck='" + ck + '\'' +
                ", accountCBRBIC='" + accountCBRBIC + '\'' +
                ", dateIn=" + dateIn +
                ", dateOut=" + dateOut +
                ", accountStatus='" + accountStatus + '\'' +
                ", accRstrListEntity=" + accRstrListEntity +
                ", bicDirectoryEntry=" + bicDirectoryEntry +
                '}';
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public String getRegulationAccountType() {
        return regulationAccountType;
    }

    public void setRegulationAccountType(String regulationAccountType) {
        this.regulationAccountType = regulationAccountType;
    }

    public String getCk() {
        return ck;
    }

    public void setCk(String ck) {
        this.ck = ck;
    }

    public String getAccountCBRBIC() {
        return accountCBRBIC;
    }

    public void setAccountCBRBIC(String accountCBRBIC) {
        this.accountCBRBIC = accountCBRBIC;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Set<AccRstrListEntity> getAccRstrListEntity() {
        return accRstrListEntity;
    }

    public void setAccRstrListEntity(Set<AccRstrListEntity> accRstrListEntity) {
        this.accRstrListEntity = accRstrListEntity;
    }

    public void addAccRstrListEntity(AccRstrListEntity accRstrList){
        this.accRstrListEntity.add(accRstrList);
    }

    public BICDirectoryEntry getBicDirectoryEntry() {
        return bicDirectoryEntry;
    }

    public void setBicDirectoryEntry(BICDirectoryEntry bicDirectoryEntry) {
        this.bicDirectoryEntry = bicDirectoryEntry;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }
}
