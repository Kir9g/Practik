package com.bank.DTO.Models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;

import java.math.BigInteger;
@Schema(description = "DTO для PartInfo")
public class PartInfoDTO {
    @Schema(description = "ID", example = "1",accessMode = Schema.AccessMode.READ_ONLY)
    private BigInteger id;
    @Schema(description = "Уникальный идентификатор совокупности частей", example = "123456789012345678901234567")
    private String PartAggregateID;
    @Schema(description = "Номер части",example = "123456")
    @Size(max = 999999)
    private BigInteger PartNo;
    @Schema(description = "Количество частей", example = "123456")
    @Size(max = 999999)
    private BigInteger PartQuantity;





    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getPartAggregateID() {
        return PartAggregateID;
    }

    public void setPartAggregateID(String partAggregateID) {
        PartAggregateID = partAggregateID;
    }

    public BigInteger getPartNo() {
        return PartNo;
    }

    public void setPartNo(BigInteger partNo) {
        PartNo = partNo;
    }

    public BigInteger getPartQuantity() {
        return PartQuantity;
    }

    public void setPartQuantity(BigInteger partQuantity) {
        PartQuantity = partQuantity;
    }

    @Override
    public String toString() {
        return "PartInfoDTO{" +
                "id=" + id +
                ", PartAggregateID='" + PartAggregateID + '\'' +
                ", PartNo=" + PartNo +
                ", PartQuantity=" + PartQuantity +
                '}';
    }
}
