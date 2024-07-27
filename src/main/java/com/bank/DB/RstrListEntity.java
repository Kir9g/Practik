package com.bank.DB;

import com.bank.DTO.ru.cbr.ed.leaftypes.v2.RstrType;
import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "RstrListEntity")
public class RstrListEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private BigInteger id;

    @ManyToOne
    @JoinColumn(name = "rstrId",nullable = false)
    private RstrEntity rstrEntity;


    @Column(name = "RstrDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date RstrDate;

    @ManyToOne()
    @JoinColumn(name = "participantInfo")
    private ParticipantInfoEntity participantInfoEntity;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public RstrEntity getRstrEntity() {
        return rstrEntity;
    }

    public void setRstrEntity(RstrEntity rstrEntity) {
        this.rstrEntity = rstrEntity;
    }

    public Date getRstrDate() {
        return RstrDate;
    }

    public void setRstrDate(Date rstrDate) {
        RstrDate = rstrDate;
    }

    public ParticipantInfoEntity getParticipantInfoEntity() {
        return participantInfoEntity;
    }

    public void setParticipantInfoEntity(ParticipantInfoEntity participantInfoEntity) {
        this.participantInfoEntity = participantInfoEntity;
    }

    @Override
    public String toString() {
        return "RstrListEntity{" +
                "id=" + id +
                ", rstrEntity=" + rstrEntity +
                ", RstrDate=" + RstrDate +
                ", participantInfoEntity=" + participantInfoEntity +
                '}';
    }
}
