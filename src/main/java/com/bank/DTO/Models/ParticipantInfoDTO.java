package com.bank.DTO.Models;

import com.bank.DB.BICDirectoryEntry;
import com.bank.DB.RstrListEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Date;
import java.util.Set;
@Schema(description = "DTO для ParticipantInfo")
public class ParticipantInfoDTO {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY,example = "1",description = "Уникальный идентификатор")
    private BigInteger id;

    @Schema(example = "ООО Ромашка", description = "Наименование участника")
    private String NameP;

    @Schema(example = "Romashka LLC", description = "Наименование участника на английском языке")
    private String EnglName;

    @Schema(example = "123456789", description = "Регистрационный порядковый номер")
    private String RegN;

    @Schema(example = "RU", description = "Код страны")
    private String CntrCd;

    @Schema(example = "77", description = "Код территории")
    private String Rgn;
    @Schema(example = "123456", description = "Индекс")
    private String ind;
    @Schema(example = "г", description = "Тип населенного пункта")
    private String Tnp;
    @Schema(example = "Москва", description = "Наименование населенного пункта")
    private String Nnp;
    @Schema(example = "ул. Пушкина, д. 1", description = "Адрес")
    private String Adr;
    @Schema(example = "044525225", description = "БИК головной организации")
    private String PrntBIC;
    @Schema(example = "2023-01-01", description = "Дата включения в состав участников перевода")
    private Date DateIn;
    @Schema(example = "2024-01-01", description = "Дата исключения информации об участнике")
    private Date DateOut;
    @Schema(example = "01", description = "Тип участника перевода")
    private String PtType;
    @Schema(example = "1", description = "Доступные сервисы перевода денежных средств")
    private Integer Srvcs;
    @Schema(example = "1", description = "Участник обмена")
    private Integer XchType;

    @Schema(example = "1234567890", description = "УИС")
    private String UID;
    @Schema(example = "ACTV", description = "Статус участника")
    private String ParticipantStatus;

    @Schema(description = "Список ограничений",accessMode = Schema.AccessMode.READ_ONLY)
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
