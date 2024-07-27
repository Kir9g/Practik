package com.bank.DB;

import com.bank.DTO.ru.cbr.ed.leaftypes.v2.ParticipantStatusType;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAttribute;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
    @Temporal(TemporalType.DATE)
    private Date DateIn;

    @Column(name = "DateOut")
    @Temporal(TemporalType.DATE)
    private Date DateOut;

    @ManyToOne
    @JoinColumn(name = "PaticioantId")
    private PtTypeEntity ptTypeEntity;

    @ManyToOne
    @JoinColumn(name = "SrvcsId")
    private SrvcsEntity srvcsEntity;

    @ManyToOne
    @JoinColumn(name = "xchTypeId",nullable = false)
    private XchTypeEntity xchTypeEntity;

    @Column(name = "UID", nullable = false)
    private String UID;

    @ManyToOne
    @JoinColumn(name = "participantStatusId",nullable = false)
    private ParticipantStatusEntity participantStatus;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "participantInfoEntity",cascade = CascadeType.ALL)
    private Set<RstrListEntity> rstrListEntity;

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

    public PtTypeEntity getPtTypeEntity() {
        return ptTypeEntity;
    }

    public void setPtTypeEntity(PtTypeEntity ptTypeEntity) {
        this.ptTypeEntity = ptTypeEntity;
    }

    public SrvcsEntity getSrvcsEntity() {
        return srvcsEntity;
    }

    public void setSrvcsEntity(SrvcsEntity srvcsEntity) {
        this.srvcsEntity = srvcsEntity;
    }

    public XchTypeEntity getXchTypeEntity() {
        return xchTypeEntity;
    }

    public void setXchTypeEntity(XchTypeEntity xchTypeEntity) {
        this.xchTypeEntity = xchTypeEntity;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public ParticipantStatusEntity getParticipantStatus() {
        return participantStatus;
    }

    public void setParticipantStatus(ParticipantStatusEntity participantStatus) {
        this.participantStatus = participantStatus;
    }

    public Set<RstrListEntity> getRstrListEntity() {
        return rstrListEntity;
    }

    public void setRstrListEntity(Set<RstrListEntity> rstrListEntity) {
        this.rstrListEntity = rstrListEntity;
    }
    public void addRstrListEntity(RstrListEntity rstrListEntity){
        this.rstrListEntity.add(rstrListEntity);
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
                ", ptTypeEntity=" + ptTypeEntity +
                ", srvcsEntity=" + srvcsEntity +
                ", xchTypeEntity=" + xchTypeEntity +
                ", UID='" + UID + '\'' +
                ", participantStatus=" + participantStatus +
                ", rstrListEntity=" + rstrListEntity +
                ", bicDirectoryEntry=" + bicDirectoryEntry +
                '}';
    }
}
