package com.bank.DB;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ED807")
public class ED807Entity {
    @Id
    @GeneratedValue
    private BigInteger Id;
    @Column(name = "EDNo", length = 9, nullable = false, unique = true)
    private BigInteger Edno;

    @Column(name = "EDDate", nullable = false)
    private Date EDDate;

    @Column(name = "EDAuthor", nullable = false, length = 10)
    private String EDAuthor;

    @Column(name = "EDReceiver", nullable = true, length = 10)
    private BigInteger EDReceiver;

    @Column(name = "CreationReason", nullable = false, length = 4)
    private String CreationReason;

    @Column(name = "CreationDateTime", nullable = false)
    private Date CreationDateTime;

    @Column(name = "InfoTypeCode", nullable = false,length = 4)
    private String InfoTypeCode;

    @Column(name = "BusinessDay", nullable = false)
    private Date BusinessDay;

    @Column(name = "DirectoryVersion", nullable = true, length = 2)
    private BigInteger DirectoryVersion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ed807EntityPartInfo", referencedColumnName = "id", nullable = true)
    private PartInfoEntity partInfoEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ed807Entity", unique = true, nullable = true)
    private InitialED initialED;

    @OneToMany(mappedBy = "ed807Entity", cascade = CascadeType.ALL, orphanRemoval=true, fetch = FetchType.EAGER)
    private List<BICDirectoryEntry> bicDirectoryEntries = new ArrayList<>();

    public BigInteger getEdno() {
        return Edno;
    }

    public void setEdno(BigInteger edno) {
        Edno = edno;
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

    public BigInteger getEDReceiver() {
        return EDReceiver;
    }

    public void setEDReceiver(BigInteger EDReceiver) {
        this.EDReceiver = EDReceiver;
    }

    public String getCreationReason() {
        return CreationReason;
    }

    public void setCreationReason(String creationReason) {
        CreationReason = creationReason;
    }

    public Date getCreationDateTime() {
        return CreationDateTime;
    }

    public void setCreationDateTime(Date creationDateTime) {
        CreationDateTime = creationDateTime;
    }

    public String getInfoTypeCode() {
        return InfoTypeCode;
    }

    public void setInfoTypeCode(String infoTypeCode) {
        InfoTypeCode = infoTypeCode;
    }

    public Date getBusinessDay() {
        return BusinessDay;
    }

    public void setBusinessDay(Date businessDay) {
        BusinessDay = businessDay;
    }

    public BigInteger getDirectoryVersion() {
        return DirectoryVersion;
    }

    public void setDirectoryVersion(BigInteger directoryVersion) {
        DirectoryVersion = directoryVersion;
    }

    public PartInfoEntity getPartInfo() {
        return partInfoEntity;
    }

    public void setPartInfo(PartInfoEntity partInfoEntity) {
        this.partInfoEntity = partInfoEntity;
    }

    public InitialED getInitialED() {
        return initialED;
    }

    public void setInitialED(InitialED initialED) {
        this.initialED = initialED;
    }

    public List<BICDirectoryEntry> getBicDirectoryEntries() {
        return bicDirectoryEntries;
    }

    public void setBicDirectoryEntries(List<BICDirectoryEntry> bicDirectoryEntries) {
        this.bicDirectoryEntries = bicDirectoryEntries;
    }

    @Override
    public String toString() {
        return "ED807Entity{" +
                "Edno=" + Edno +
                ", EDDate=" + EDDate +
                ", EDAuthor='" + EDAuthor + '\'' +
                ", EDReceiver=" + EDReceiver +
                ", CreationReason='" + CreationReason + '\'' +
                ", CreationDateTime=" + CreationDateTime +
                ", InfoTypeCode='" + InfoTypeCode + '\'' +
                ", BusinessDay=" + BusinessDay +
                ", DirectoryVersion=" + DirectoryVersion +
                ", partInfo=" + partInfoEntity +
                ", initialED=" + initialED +
                ", bicDirectoryEntries=" + bicDirectoryEntries +
                '}';
    }
}
