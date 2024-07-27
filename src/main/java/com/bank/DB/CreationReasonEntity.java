package com.bank.DB;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CreationReason")
public class CreationReasonEntity {
    @Id
    @GeneratedValue
    private BigInteger id;

    @Column(name = "name",length = 4)
    private String name;

    @Column(name = "description",length = 500)
    private String description;

    @OneToMany(mappedBy = "creationReason", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ED807Entity> ed807Entities = new HashSet<>();

    public BigInteger getId() {
        return id;
    }

    public Set<ED807Entity> getEd807Entities() {
        return ed807Entities;
    }

    public void setEd807Entities(Set<ED807Entity> ed807Entities) {
        this.ed807Entities = ed807Entities;
    }

    @Override
    public String toString() {
        return "CreationReasonEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ed807Entities=" + ed807Entities +
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
