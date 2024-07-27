package com.bank.Repository;

import com.bank.DB.RstrEntity;
import com.bank.DB.SrvcsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface RstrRepository extends JpaRepository<RstrEntity, BigInteger> {
    RstrEntity findByName(String name);
}
