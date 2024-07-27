package com.bank.DB;

import jakarta.persistence.Entity;


import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "RstrEntity")
public class RstrEntity {
    @Id
    @GeneratedValue
    private BigInteger id;

    @Column(name = "name",length = 4)
    private String name;

    @Column(name = "description",length = 500)
    private String description;

    @OneToMany(mappedBy = "rstrEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RstrListEntity> rstrListEntities = new HashSet<>();

    public BigInteger getId() {
        return id;
    }

    public Set<RstrListEntity> getRstrListEntities() {
        return rstrListEntities;
    }

    public void setRstrListEntities(Set<RstrListEntity> rstrListEntities) {
        this.rstrListEntities = rstrListEntities;
    }

    @Override
    public String toString() {
        return "RstrEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rstrListEntities=" + rstrListEntities +
                '}';
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
