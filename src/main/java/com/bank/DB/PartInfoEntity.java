package com.bank.DB;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "PartInfo")
public class PartInfoEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "PartAggregateID",nullable = false,length = 27)
    private String PartAggregateID;

    @Column(name = "PartNo", nullable = false, length = 6)
    private BigInteger PartNo;

    @Column(name = "PartQuantity", nullable = false, length = 6)
    private BigInteger PartQuantity;

    @OneToOne()
    @JoinColumn(name = "ed807EntityPartInfo")
    private ED807Entity ed807EntityPartInfo;

    public ED807Entity getEd807Entity() {
        return ed807EntityPartInfo;
    }

    public void setEd807Entity(ED807Entity ed807Entity) {
        this.ed807EntityPartInfo = ed807Entity;
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

    public String getPartAggregateID() {
        return PartAggregateID;
    }

    public void setPartAggregateID(String partAggregateID) {
        PartAggregateID = partAggregateID;
    }

    @Override
    public String toString() {
        return "PartInfo{" +
                "PartAggregateID='" + PartAggregateID + '\'' +
                ", PartNo=" + PartNo +
                ", PartQuantity=" + PartQuantity +
                ", ed807Entity=" + ed807EntityPartInfo +
                '}';
    }
}
