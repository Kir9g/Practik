package com.bank.DB;

import jakarta.persistence.Entity;


import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SrvcsEntity")
public class SrvcsEntity {
    @Id
    @GeneratedValue
    private BigInteger id;

    @Column(name = "name",length = 1)
    private Integer name;

    @Column(name = "description",length = 500)
    private String description;

    @OneToMany(mappedBy = "srvcsEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ParticipantInfoEntity> participantInfoEntities = new HashSet<>();

    public BigInteger getId() {
        return id;
    }

    public Set<ParticipantInfoEntity> getParticipantInfoEntities() {
        return participantInfoEntities;
    }

    public void setParticipantInfoEntities(Set<ParticipantInfoEntity> participantInfoEntities) {
        this.participantInfoEntities = participantInfoEntities;
    }

    @Override
    public String toString() {
        return "PtTypeEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", participantInfoEntities=" + participantInfoEntities +
                '}';
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
