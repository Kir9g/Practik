package com.bank.DB;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "PartInfo")
public class PartInfoEntity {
    @Id
    @GeneratedValue
    private BigInteger id;

    @Column(name = "PartAggregateID",nullable = false,length = 27)
    private String PartAggregateID;

    @Column(name = "PartNo", nullable = false, length = 6)
    private BigInteger PartNo;

    @Column(name = "PartQuantity", nullable = false, length = 6)
    private BigInteger PartQuantity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ed807EntityPartInfo")
    private ED807Entity ed807EntityPartInfo;

    public ED807Entity getEd807Entity() {
        return ed807EntityPartInfo;
    }

    @Override
    public String toString() {
        return "PartInfoEntity{" +
                "id=" + id +
                ", PartAggregateID='" + PartAggregateID + '\'' +
                ", PartNo=" + PartNo +
                ", PartQuantity=" + PartQuantity +
                ", ed807EntityPartInfo=" + ed807EntityPartInfo +
                '}';
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
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

    public ED807Entity getEd807EntityPartInfo() {
        return ed807EntityPartInfo;
    }

    public void setEd807EntityPartInfo(ED807Entity ed807EntityPartInfo) {
        this.ed807EntityPartInfo = ed807EntityPartInfo;
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

}