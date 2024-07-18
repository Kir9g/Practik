package com.bank.DB;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "SWBICS")
public class SWBICSEntity {

    @Id
    @GeneratedValue
    private BigInteger Id;

    @Column(name = "SWBIC",length = 11,nullable = false)
    private String SWBIC;

    @Column(name = "DefaultSWBIC", nullable = false)
    private boolean DefaultSWBIC;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BIC")
    private BICDirectoryEntry bicDirectoryEntry;

    public String getSWBIC() {
        return SWBIC;
    }

    public BigInteger getId() {
        return Id;
    }

    @Override
    public String toString() {
        return "SWBICSEntity{" +
                "Id=" + Id +
                ", SWBIC='" + SWBIC + '\'' +
                ", DefaultSWBIC=" + DefaultSWBIC +
                ", bicDirectoryEntry=" + bicDirectoryEntry +
                '}';
    }

    public void setId(BigInteger id) {
        Id = id;
    }

    public void setSWBIC(String SWBIC) {
        this.SWBIC = SWBIC;
    }

    public boolean isDefaultSWBIC() {
        return DefaultSWBIC;
    }

    public void setDefaultSWBIC(boolean defaultSWBIC) {
        DefaultSWBIC = defaultSWBIC;
    }

    public BICDirectoryEntry getBicDirectoryEntry() {
        return bicDirectoryEntry;
    }

    public void setBicDirectoryEntry(BICDirectoryEntry bicDirectoryEntry) {
        this.bicDirectoryEntry = bicDirectoryEntry;
    }

}
