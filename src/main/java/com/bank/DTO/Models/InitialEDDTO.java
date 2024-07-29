package com.bank.DTO.Models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;

import java.math.BigInteger;
import java.util.Date;
@Schema(description = "DTO для InitialED")
public class InitialEDDTO {

    @Schema(description = "ID", example = "1",accessMode = Schema.AccessMode.READ_ONLY)
    private BigInteger id;

    @Schema(description = "Номер ЭС в течение опердня.",example = "14313")
    @Size(max = 999999999,min = 0)
    private BigInteger edno;

    @Schema(description = "Дата составления ЭС.", example = "2024-01-01")
    private Date eddate;

    @Schema(description = "Уникальный идентификатор составителя ЭС - УИС., Цифровой, 10 знаков.",example = "4583001999")
    private String edauthor;

    @Override
    public String toString() {
        return "InitialEDDTO{" +
                "ID=" + id +
                ", eDNo=" + edno +
                ", eDDate=" + eddate +
                ", eDAuthor='" + edauthor + '\'' +
                '}';
    }

    public BigInteger getID() {
        return id;
    }

    public void setID(BigInteger ID) {
        this.id = ID;
    }

    public BigInteger getEDNo() {
        return edno;
    }

    public void setEDNo(BigInteger EDNo) {
        this.edno = EDNo;
    }

    public Date getEDDate() {
        return eddate;
    }

    public void setEDDate(Date EDDate) {
        this.eddate = EDDate;
    }

    public String getEDAuthor() {
        return edauthor;
    }

    public void setEDAuthor(String EDAuthor) {
        this.edauthor = EDAuthor;
    }
}
