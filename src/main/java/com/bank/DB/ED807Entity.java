package com.bank.DB;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.*;

@Entity
@Table(name = "ED807")
public class ED807Entity {
    @Id
    @GeneratedValue()
    private BigInteger Id;

    @Column(name = "name")
    private String name;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "CreationDate")
    @Temporal(TemporalType.DATE)
    private Date CreationDate;

    @Column(name = "EDNo", length = 9, nullable = false, unique = true)
    private BigInteger Edno;

    @Column(name = "EDDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date EDDate;

    @Column(name = "EDAuthor", nullable = false, length = 10)
    private String EDAuthor;

    @Column(name = "EDReceiver", nullable = true, length = 10)
    private BigInteger EDReceiver;

    @ManyToOne
    @JoinColumn(name = "creationReason_id", nullable = false)
    private CreationReasonEntity creationReason;

    @Column(name = "CreationDateTime", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date CreationDateTime;

    @ManyToOne
    @JoinColumn(name = "InfoTypeCodeId", nullable = false)
    private InfoTypeCodeEntity infoTypeCodeEntity;

    @Column(name = "BusinessDay", nullable = false)
    @Temporal(TemporalType.DATE)
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
    private Set<BICDirectoryEntry> bicDirectoryEntries = new HashSet<>();

    public BigInteger getId() {
        return Id;
    }

    public void setId(BigInteger id) {
        Id = id;
    }

    public void setBicDirectoryEntries(Set<BICDirectoryEntry> bicDirectoryEntries) {
        this.bicDirectoryEntries = bicDirectoryEntries;
    }

    public CreationReasonEntity getCreationReason() {
        return creationReason;
    }

    public void setCreationReason(CreationReasonEntity creationReason) {
        this.creationReason = creationReason;
    }

    @Override
    public String toString() {
        return "ED807Entity{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", filePath='" + filePath + '\'' +
                ", CreationDate=" + CreationDate +
                ", Edno=" + Edno +
                ", EDDate=" + EDDate +
                ", EDAuthor='" + EDAuthor + '\'' +
                ", EDReceiver=" + EDReceiver +
                ", creationReason=" + creationReason +
                ", CreationDateTime=" + CreationDateTime +
                ", infoTypeCodeEntity=" + infoTypeCodeEntity +
                ", BusinessDay=" + BusinessDay +
                ", DirectoryVersion=" + DirectoryVersion +
                ", partInfoEntity=" + partInfoEntity +
                ", initialED=" + initialED +
                ", bicDirectoryEntries=" + bicDirectoryEntries +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(Date creationDate) {
        CreationDate = creationDate;
    }

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


    public Date getCreationDateTime() {
        return CreationDateTime;
    }

    public void setCreationDateTime(Date creationDateTime) {
        CreationDateTime = creationDateTime;
    }

    public InfoTypeCodeEntity getInfoTypeCodeEntity() {
        return infoTypeCodeEntity;
    }

    public void setInfoTypeCodeEntity(InfoTypeCodeEntity infoTypeCodeEntity) {
        this.infoTypeCodeEntity = infoTypeCodeEntity;
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

    public PartInfoEntity getPartInfoEntity() {
        return partInfoEntity;
    }

    public void setPartInfoEntity(PartInfoEntity partInfoEntity) {
        this.partInfoEntity = partInfoEntity;
    }

    public InitialED getInitialED() {
        return initialED;
    }

    public void setInitialED(InitialED initialED) {
        this.initialED = initialED;
    }

    public Set<BICDirectoryEntry> getBicDirectoryEntries() {
        return bicDirectoryEntries;
    }

    public void addBicDirectoryEntries(BICDirectoryEntry bicDirectoryEntries) {
        this.bicDirectoryEntries.add(bicDirectoryEntries);
    }
}