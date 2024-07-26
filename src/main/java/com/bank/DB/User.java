package com.bank.DB;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue()
    private BigInteger ID;

    @Column(name = "username", unique = true, nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE")
    private RoleEnum ROLE;

    public BigInteger getID() {
        return ID;
    }

    public void setID(BigInteger ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleEnum getROLE() {
        return ROLE;
    }

    public void setROLE(RoleEnum ROLE) {
        this.ROLE = ROLE;
    }

    public User() {
    }

    public User(BigInteger ID, String username, String password, RoleEnum ROLE) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.ROLE = ROLE;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", ROLE=" + ROLE +
                '}';
    }
}
