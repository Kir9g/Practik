package com.bank.Repository;

import com.bank.DB.AccRstrEntity;
import com.bank.DB.ChangeTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface AccRstrRepository extends JpaRepository<AccRstrEntity, BigInteger> {
    AccRstrEntity findByName(String name);
}
