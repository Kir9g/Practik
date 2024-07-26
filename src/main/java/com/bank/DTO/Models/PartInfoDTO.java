package com.bank.DTO.Models;

import jakarta.persistence.Column;

import java.math.BigInteger;

public class PartInfoDTO {
    private BigInteger id;

    private String PartAggregateID;

    private BigInteger PartNo;

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
