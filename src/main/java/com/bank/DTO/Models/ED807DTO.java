package com.bank.DTO.Models;

import com.bank.DB.BICDirectoryEntry;
import com.bank.DB.InitialED;
import com.bank.DB.PartInfoEntity;
import com.bank.DTO.ru.cbr.ed.v2.PartInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Schema(description = "DTO для представления информации о записи в справочнике ED807")
public class ED807DTO {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Уникальный идентификатор ED807")
    private BigInteger Id;

    @Schema(description = "Название ED807 в системе")
    private String name;

    @Schema(description = "Путь к файлу")
    private String filePath;

    @Schema(description = "Время когда файл был загуржен в систему",example = "2023-01-01")
    @Temporal(TemporalType.DATE)
    private Date CreationDate;

    @Schema(description = "Номер ЭС в течение опердня.")
    @Size()
    private BigInteger Edno;

    @Schema(description = "Дата составления ЭС", example = "2023-01-01")
    private Date EDDate;

    @Schema(description = "Уникальный идентификатор составителя ЭС", example = "1234567890")
    private String EDAuthor;
    @Schema(description = "Уникальный идентификатор получателя ЭС", example = "1234567890")
    private BigInteger EDReceiver;

    @Schema(description = "Код причины формирования ЭС", example = "RQST")
    @Size(min = 4,max = 4)
    private String CreationReason;

    @Temporal(TemporalType.DATE)
    @Schema(description = "Дата и время создания ЭС.",example = "2023-01-01" )
    private Date CreationDateTime;

    @Schema(description = "Вид представления информации.", example = "FIRR")
    @Size(max = 4,min = 4)
    private String InfoTypeCode;

    @Temporal(TemporalType.DATE)
    @Schema(description = "Дата ОД, к которой относятся данные Справочника БИК.", example = "2023-01-01")
    private Date BusinessDay;
    @Schema(description = "Номер версии Справочника БИК в течение операционного дня.", example = "1")
    @Size(max = 99,min = 1)
    private BigInteger DirectoryVersion;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private PartInfoDTO partInfoDTO;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private InitialEDDTO initialEDDTO;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
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
