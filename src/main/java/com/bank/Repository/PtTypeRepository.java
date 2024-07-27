package com.bank.Repository;

import com.bank.DB.ChangeTypeEntity;
import com.bank.DB.PtTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface PtTypeRepository extends JpaRepository<PtTypeEntity, BigInteger> {
    PtTypeEntity findByName(String name);
}
