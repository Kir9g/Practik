package com.bank.DB;

import jakarta.persistence.Entity;


import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ChangeTypeEntity")
public class ChangeTypeEntity {
    @Id
    @GeneratedValue
    private BigInteger id;

    @Column(name = "name",length = 4)
    private String name;

    @Column(name = "description",length = 500)
    private String description;

    @OneToMany(mappedBy = "changeType", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BICDirectoryEntry> bicDirectoryEntries = new HashSet<>();

    public BigInteger getId() {
        return id;
    }

    public Set<BICDirectoryEntry> getBicDirectoryEntries() {
        return bicDirectoryEntries;
    }

    public void setBicDirectoryEntries(Set<BICDirectoryEntry> bicDirectoryEntries) {
        this.bicDirectoryEntries = bicDirectoryEntries;
    }

    @Override
    public String toString() {
        return "ChangeTypeEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", bicDirectoryEntries=" + bicDirectoryEntries +
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
