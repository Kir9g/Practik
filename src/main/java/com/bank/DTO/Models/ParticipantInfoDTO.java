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
    private String nameP;

    @Schema(example = "Romashka LLC", description = "Наименование участника на английском языке")
    private String englName;

    @Schema(example = "123456789", description = "Регистрационный порядковый номер")
    private String regN;

    @Schema(example = "RU", description = "Код страны")
    private String cntrCd;

    @Schema(example = "77", description = "Код территории")
    private String rgn;
    @Schema(example = "123456", description = "Индекс")
    private String ind;
    @Schema(example = "г", description = "Тип населенного пункта")
    private String tnp;
    @Schema(example = "Москва", description = "Наименование населенного пункта")
    private String nnp;
    @Schema(example = "ул. Пушкина, д. 1", description = "Адрес")
    private String adr;
    @Schema(example = "044525225", description = "БИК головной организации")
    private String prntBIC;
    @Schema(example = "2023-01-01", description = "Дата включения в состав участников перевода")
    private Date DateIn;
    @Schema(example = "2024-01-01", description = "Дата исключения информации об участнике")
    private Date DateOut;
    @Schema(example = "01", description = "Тип участника перевода")
    private String ptType;
    @Schema(example = "1", description = "Доступные сервисы перевода денежных средств")
    private Integer srvcs;
    @Schema(example = "1", description = "Участник обмена")
    private Integer xchType;

    @Schema(example = "1234567890", description = "УИС")
    private String uid;
    @Schema(example = "ACTV", description = "Статус участника")
    private String participantStatus;

    @Schema(description = "Список ограничений",accessMode = Schema.AccessMode.READ_ONLY)
    private Set<RstrListDTO> rstrListEntity;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    public String getEnglName() {
        return englName;
    }

    public void setEnglName(String englName) {
        this.englName = englName;
    }

    public String getRegN() {
        return regN;
    }

    public void setRegN(String regN) {
        this.regN = regN;
    }

    public String getCntrCd() {
        return cntrCd;
    }

    public void setCntrCd(String cntrCd) {
        this.cntrCd = cntrCd;
    }

    public String getRgn() {
        return rgn;
    }

    public void setRgn(String rgn) {
        this.rgn = rgn;
    }

    public String getInd() {
        return ind;
    }

    public void setInd(String ind) {
        this.ind = ind;
    }

    public String getTnp() {
        return tnp;
    }

    public void setTnp(String tnp) {
        this.tnp = tnp;
    }

    public String getNnp() {
        return nnp;
    }

    public void setNnp(String nnp) {
        this.nnp = nnp;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public String getPrntBIC() {
        return prntBIC;
    }

    public void setPrntBIC(String prntBIC) {
        this.prntBIC = prntBIC;
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
        return ptType;
    }

    public void setPtType(String ptType) {
        this.ptType = ptType;
    }

    public Integer getSrvcs() {
        return srvcs;
    }

    public void setSrvcs(Integer srvcs) {
        this.srvcs = srvcs;
    }

    public Integer getXchType() {
        return xchType;
    }

    public void setXchType(Integer xchType) {
        this.xchType = xchType;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getParticipantStatus() {
        return participantStatus;
    }

    public void setParticipantStatus(String participantStatus) {
        this.participantStatus = participantStatus;
    }

    public Set<RstrListDTO> getRstrListEntity() {
        return rstrListEntity;
    }

    public void setRstrListEntity(Set<RstrListDTO> rstrListEntity) {
        this.rstrListEntity = rstrListEntity;
    }
}
