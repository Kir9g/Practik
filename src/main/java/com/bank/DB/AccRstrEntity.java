package com.bank.DB;

import jakarta.persistence.Entity;


import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "AccRstrEntity")
public class AccRstrEntity {
    @Id
    @GeneratedValue
    private BigInteger id;

    @Column(name = "name",length = 4)
    private String name;

    @Column(name = "description",length = 500)
    private String description;

    @OneToMany(mappedBy = "accRstrEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AccRstrListEntity> accRstrListEntities= new HashSet<>();

    public BigInteger getId() {
        return id;
    }

    public Set<AccRstrListEntity> getAccRstrListEntities() {
        return accRstrListEntities;
    }

    public void setAccRstrListEntities(Set<AccRstrListEntity> accRstrListEntities) {
        this.accRstrListEntities = accRstrListEntities;
    }

    @Override
    public String toString() {
        return "AccRstrEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", accRstrListEntities=" + accRstrListEntities +
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
