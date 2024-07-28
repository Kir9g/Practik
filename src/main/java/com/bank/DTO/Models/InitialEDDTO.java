package com.bank.DTO.Models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;

import java.math.BigInteger;
import java.util.Date;
@Schema(description = "DTO для InitialED")
public class InitialEDDTO {

    @Schema(description = "ID", example = "1",accessMode = Schema.AccessMode.READ_ONLY)
    private BigInteger ID;

    @Schema(description = "Номер ЭС в течение опердня.",example = "14313")
    @Size(max = 999999999,min = 0)
    private BigInteger EDNo;

    @Schema(description = "Дата составления ЭС.", example = "2024-01-01")
    private Date EDDate;

    @Schema(description = "Уникальный идентификатор составителя ЭС - УИС., Цифровой, 10 знаков.",example = "4583001999")
    private String EDAuthor;

    @Override
    public String toString() {
        return "InitialEDDTO{" +
                "ID=" + ID +
                ", EDNo=" + EDNo +
                ", EDDate=" + EDDate +
                ", EDAuthor='" + EDAuthor + '\'' +
                '}';
    }

    public BigInteger getID() {
        return ID;
    }

    public void setID(BigInteger ID) {
        this.ID = ID;
    }

    public BigInteger getEDNo() {
        return EDNo;
    }

    public void setEDNo(BigInteger EDNo) {
        this.EDNo = EDNo;
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
}
