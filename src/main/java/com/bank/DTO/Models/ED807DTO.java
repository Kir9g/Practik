package com.bank.DTO.Models;

import com.bank.DB.BICDirectoryEntry;
import com.bank.DB.InitialED;
import com.bank.DB.PartInfoEntity;
import com.bank.DTO.ru.cbr.ed.v2.PartInfo;
import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ED807DTO {
    private BigInteger Id;


    private String name;


    private String filePath;

    @Temporal(TemporalType.DATE)
    private Date CreationDate;


    private BigInteger Edno;


    private Date EDDate;


    private String EDAuthor;

    private BigInteger EDReceiver;


    private String CreationReason;

    @Temporal(TemporalType.DATE)
    private Date CreationDateTime;


    private String InfoTypeCode;

    @Temporal(TemporalType.DATE)
    private Date BusinessDay;

    private BigInteger DirectoryVersion;


    private PartInfoDTO partInfoDTO;

    private InitialEDDTO initialEDDTO;

    private Set<BicDirectoryDTO> bicDirectoryDTOS = new HashSet<>();

    @Override
    public String toString() {
        return "ED807DTO{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", filePath='" + filePath + '\'' +
                ", CreationDate=" + CreationDate +
                ", Edno=" + Edno +
                ", EDDate=" + EDDate +
                ", EDAuthor='" + EDAuthor + '\'' +
                ", EDReceiver=" + EDReceiver +
                ", CreationReason='" + CreationReason + '\'' +
                ", CreationDateTime=" + CreationDateTime +
                ", InfoTypeCode='" + InfoTypeCode + '\'' +
                ", BusinessDay=" + BusinessDay +
                ", DirectoryVersion=" + DirectoryVersion +
                ", partInfoDTO=" + partInfoDTO +
                ", initialEDDTO=" + initialEDDTO +
                ", bicDirectoryDTOS=" + bicDirectoryDTOS +
                '}';
    }

    public BigInteger getId() {
        return Id;
    }

    public void setId(BigInteger id) {
        Id = id;
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

    public PartInfoDTO getPartInfoDTO() {
        return partInfoDTO;
    }

    public void setPartInfoDTO(PartInfoDTO partInfoDTO) {
        this.partInfoDTO = partInfoDTO;
    }

    public InitialEDDTO getInitialEDDTO() {
        return initialEDDTO;
    }

    public void setInitialEDDTO(InitialEDDTO initialEDDTO) {
        this.initialEDDTO = initialEDDTO;
    }

    public Set<BicDirectoryDTO> getBicDirectoryDTOS() {
        return bicDirectoryDTOS;
    }

    public void setBicDirectoryDTOS(Set<BicDirectoryDTO> bicDirectoryDTOS) {
        this.bicDirectoryDTOS = bicDirectoryDTOS;
    }
}
