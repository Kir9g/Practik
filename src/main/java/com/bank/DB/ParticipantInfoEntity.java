package com.bank.DB;

import com.bank.DTO.ru.cbr.ed.leaftypes.v2.ParticipantStatusType;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAttribute;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ParticipantInfo")
public class ParticipantInfoEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private BigInteger id;

    @Column(name = "NameP", length = 160, nullable = false)
    private String NameP;

    @Column(name = "EnglName", length = 140, nullable = true)
    private String EnglName;

    @Column(name = "RegN", length = 9, nullable = true)
    private String RegN;

    @Column(name = "CntrCd", length = 2, nullable = true)
    private String CntrCd;

    @Column(name = "Rgn",length = 2, nullable = false)
    private String Rgn;

    @Column(name = "ind", length = 6,nullable = true)
    private String ind;

    @Column(name = "Tnp",length = 5, nullable = true)
    private String Tnp;

    @Column(name = "Nnp", length = 25, nullable = true)
    private String Nnp;

    @Column(name = "Adr",length = 160)
    private String Adr;

    @Column(name = "PrntBIC", length = 9)
    private String PrntBIC;

    @Column(name = "DateIn", nullable = false)
    private Date DateIn;

    @Column(name = "DateOut")
    private Date DateOut;

    @Column(name = "PtType", nullable = false)
    private String PtType;

    @Column(name = "Srvcs", nullable = false)
    private String Srvcs;

    @Column(name = "XchType", nullable = false)
    private String XchType;

    @Column(name = "UID", nullable = false)
    private String UID;

    @Column(name = "ParticipantStatus", length = 4)
    private String ParticipantStatus;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "participantInfoEntity",cascade = CascadeType.ALL)
    private List<RstrListEntity> rstrListEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BIC")
    private BICDirectoryEntry bicDirectoryEntry;

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

    public String getSrvcs() {
        return Srvcs;
    }

    public void setSrvcs(String srvcs) {
        Srvcs = srvcs;
    }

    public String getXchType() {
        return XchType;
    }

    public void setXchType(String xchType) {
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

    public List<RstrListEntity> getRstrListEntity() {
        return rstrListEntity;
    }

    public void setRstrListEntity(List<RstrListEntity> rstrListEntity) {
        this.rstrListEntity = rstrListEntity;
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

    @Override
    public String toString() {
        return "ParticipantInfoEntity{" +
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
                ", Srvcs='" + Srvcs + '\'' +
                ", XchType='" + XchType + '\'' +
                ", UID='" + UID + '\'' +
                ", ParticipantStatus='" + ParticipantStatus + '\'' +
                ", rstrListEntity=" + rstrListEntity +
                ", bicDirectoryEntry=" + bicDirectoryEntry +
                '}';
    }
}
