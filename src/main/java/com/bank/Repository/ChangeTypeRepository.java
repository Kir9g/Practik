package com.bank.Repository;

import com.bank.DB.ChangeTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface ChangeTypeRepository extends JpaRepository<ChangeTypeEntity, BigInteger> {
    ChangeTypeEntity findByName(String name);
}
