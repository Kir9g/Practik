package com.bank.Repository;

import com.bank.DB.ChangeTypeEntity;
import com.bank.DB.SrvcsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface SrvcsRepository extends JpaRepository<SrvcsEntity, BigInteger> {
    SrvcsEntity findByName(Integer name);
}