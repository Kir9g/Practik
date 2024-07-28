package com.bank.DTO.Models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigInteger;
import java.util.Date;

@Schema(description = "DTO для сущности AccRstrListEntity")
public class AccRstrListDTO {

    @Schema(description = "Идентификатор ограничения", example = "1",accessMode = Schema.AccessMode.READ_ONLY)
    private BigInteger id;

    @Schema(description = "Код ограничения операций по счету", required = true, example = "1234")
    @NotNull(message = "AccRstr не может быть пустым")
    @Size(min = 4, max = 4, message = "AccRstr должен содержать ровно 4 символа")
    private String accRstr;

    @Schema(description = "Дата начала действия ограничения", required = true, example = "2023-01-01")
    @NotNull(message = "AccRstrDate не может быть пустым")
    private Date accRstrDate;

    @Schema(description = "БИК преемника", example = "123456789")
    @Size(min = 9, max = 9, message = "SuccessorBIC должен содержать ровно 9 символов")
    private String successorBIC;


    // Getters and setters

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getAccRstr() {
        return accRstr;
    }

    public void setAccRstr(String accRstr) {
        this.accRstr = accRstr;
    }

    public Date getAccRstrDate() {
        return accRstrDate;
    }

    public void setAccRstrDate(Date accRstrDate) {
        this.accRstrDate = accRstrDate;
    }

    public String getSuccessorBIC() {
        return successorBIC;
    }

    public void setSuccessorBIC(String successorBIC) {
        this.successorBIC = successorBIC;
    }

    @Override
    public String toString() {
        return "AccRstrListDTO{" +
                "id=" + id +
                ", accRstr='" + accRstr + '\'' +
                ", accRstrDate=" + accRstrDate +
                ", successorBIC='" + successorBIC + '\'' +
                '}';
    }
}
