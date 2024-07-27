package com.bank.Repository;

import com.bank.DB.PtTypeEntity;
import com.bank.DB.RegulationAccountTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface RegulationAccountTypeRepository extends JpaRepository<RegulationAccountTypeEntity, BigInteger> {
    RegulationAccountTypeEntity findByName(String name);
}
