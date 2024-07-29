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
    private String partAggregateID;
    @Schema(description = "Номер части",example = "123456")
    @Size(max = 999999)
    private BigInteger partNo;
    @Schema(description = "Количество частей", example = "123456")
    @Size(max = 999999)
    private BigInteger partQuantity;





    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getPartAggregateID() {
        return partAggregateID;
    }

    public void setPartAggregateID(String partAggregateID) {
        this.partAggregateID = partAggregateID;
    }

    public BigInteger getPartNo() {
        return partNo;
    }

    public void setPartNo(BigInteger partNo) {
        this.partNo = partNo;
    }

    public BigInteger getPartQuantity() {
        return partQuantity;
    }

    public void setPartQuantity(BigInteger partQuantity) {
        this.partQuantity = partQuantity;
    }

    @Override
    public String toString() {
        return "PartInfoDTO{" +
                "id=" + id +
                ", PartAggregateID='" + partAggregateID + '\'' +
                ", PartNo=" + partNo +
                ", PartQuantity=" + partQuantity +
                '}';
    }
}
