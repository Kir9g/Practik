package com.bank.DTO.Models;

import com.bank.DTO.ru.cbr.ed.leaftypes.v2.RstrType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.math.BigInteger;
import java.util.Date;
@Schema(description = "DTO для RstrList")
public class RstrListDTO {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY,example = "1")
    private BigInteger id;

    @Schema(description = "Код ограничения, наложенного на участника.", example = "URRS")
    private String Rstr;

    @Temporal(TemporalType.DATE)
    @Schema(description = "Дата начала действия ограничения участника.", example = "2023-01-01")
    private Date RstrDate;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getRstr() {
        return Rstr;
    }

    public void setRstr(String rstr) {
        Rstr = rstr;
    }

    public Date getRstrDate() {
        return RstrDate;
    }

    public void setRstrDate(Date rstrDate) {
        RstrDate = rstrDate;
    }

    @Override
    public String toString() {
        return "RstrListDTO{" +
                "id=" + id +
                ", Rstr='" + Rstr + '\'' +
                ", RstrDate=" + RstrDate +
                '}';
    }
}
