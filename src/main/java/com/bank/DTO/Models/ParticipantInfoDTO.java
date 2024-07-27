package com.bank.DTO.Models;

import com.bank.DB.BICDirectoryEntry;
import com.bank.DB.RstrListEntity;
import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Date;
import java.util.Set;

public class ParticipantInfoDTO {

    private BigInteger id;


    private String NameP;


    private String EnglName;


    private String RegN;


    private String CntrCd;


    private String Rgn;

    private String ind;

    private String Tnp;

    private String Nnp;

    private String Adr;

    private String PrntBIC;

    private Date DateIn;

    private Date DateOut;

    private String PtType;

    private Integer Srvcs;

    private Integer XchType;

    private String UID;

    private String ParticipantStatus;

    private Set<RstrListDTO> rstrListEntity;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getNameP() {
        return NameP;
    }

    public void setNameP(String nameP) {
        NameP = nameP;
    }

    public String getEnglName() {
        return EnglName;
    }

    public void setEnglName(String englName) {
        EnglName = englName;
    }

    public String getRegN() {
        return RegN;
    }

    public void setRegN(String regN) {
        RegN = regN;
    }

    public String getCntrCd() {
        return CntrCd;
    }

    public void setCntrCd(String cntrCd) {
        CntrCd = cntrCd;
    }

    public String getRgn() {
        return Rgn;
    }

    public void setRgn(String rgn) {
        Rgn = rgn;
    }

    public String getInd() {
        return ind;
    }

    public void setInd(String ind) {
        this.ind = ind;
    }

    public String getTnp() {
        return Tnp;
    }

    public void setTnp(String tnp) {
        Tnp = tnp;
    }

    public String getNnp() {
        return Nnp;
    }

    public void setNnp(String nnp) {
        Nnp = nnp;
    }

    public String getAdr() {
        return Adr;
    }

    public void setAdr(String adr) {
        Adr = adr;
    }

    public String getPrntBIC() {
        return PrntBIC;
    }

    public void setPrntBIC(String prntBIC) {
        PrntBIC = prntBIC;
    }

    public Date getDateIn() {
        return DateIn;
    }

    public void setDateIn(Date dateIn) {
        DateIn = dateIn;
    }

    public Date getDateOut() {
        return DateOut;
    }

    public void setDateOut(Date dateOut) {
        DateOut = dateOut;
    }

    public String getPtType() {
        return PtType;
    }

    public void setPtType(String ptType) {
        PtType = ptType;
    }

    public Integer getSrvcs() {
        return Srvcs;
    }

    public void setSrvcs(Integer srvcs) {
        Srvcs = srvcs;
    }

    public Integer getXchType() {
        return XchType;
    }

    public void setXchType(Integer xchType) {
        XchType = xchType;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getParticipantStatus() {
        return ParticipantStatus;
    }

    public void setParticipantStatus(String participantStatus) {
        ParticipantStatus = participantStatus;
    }

    public Set<RstrListDTO> getRstrListEntity() {
        return rstrListEntity;
    }

    public void setRstrListEntity(Set<RstrListDTO> rstrListEntity) {
        this.rstrListEntity = rstrListEntity;
    }

    @Override
    public String toString() {
        return "ParticipantInfoDTO{" +
                "id=" + id +
                ", NameP='" + NameP + '\'' +
                ", EnglName='" + EnglName + '\'' +
                ", RegN='" + RegN + '\'' +
                ", CntrCd='" + CntrCd + '\'' +
                ", Rgn='" + Rgn + '\'' +
                ", ind='" + ind + '\'' +
                ", Tnp='" + Tnp + '\'' +
                ", Nnp='" + Nnp + '\'' +
                ", Adr='" + Adr + '\'' +
                ", PrntBIC='" + PrntBIC + '\'' +
                ", DateIn=" + DateIn +
                ", DateOut=" + DateOut +
                ", PtType='" + PtType + '\'' +
                ", Srvcs=" + Srvcs +
                ", XchType=" + XchType +
                ", UID='" + UID + '\'' +
                ", ParticipantStatus='" + ParticipantStatus + '\'' +
                ", rstrListEntity=" + rstrListEntity +
                '}';
    }
}
