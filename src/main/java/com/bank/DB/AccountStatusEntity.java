package com.bank.DB;

import jakarta.persistence.Entity;


import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "AccountStatusEntity")
public class AccountStatusEntity {
    @Id
    @GeneratedValue
    private BigInteger id;

    @Column(name = "name",length = 4)
    private String name;

    @Column(name = "description",length = 500)
    private String description;

    @OneToMany(mappedBy = "accountStatusEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Accounts> accounts = new HashSet<>();

    public BigInteger getId() {
        return id;
    }

    public Set<Accounts> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Accounts> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "AccountStatusEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", accounts=" + accounts +
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
