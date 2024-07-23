package com.bank.DB;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;

@Entity
@Table(name = "USERS")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger ID;

    @Column(unique = true, name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "ROLE")
    private String ROLE;

    public BigInteger getID() {
        return ID;
    }

    public void setID(BigInteger ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getROLE() {
        return ROLE;
    }

    public void setROLE(String ROLE) {
        this.ROLE = ROLE;
    }


    public User() {
    }

    public User(BigInteger ID, String name, String password, String ROLE) {
        this.ID = ID;
        this.name = name;
        this.password = password;
        this.ROLE = ROLE;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", ROLE='" + ROLE + '\'' +
                '}';
    }
}
