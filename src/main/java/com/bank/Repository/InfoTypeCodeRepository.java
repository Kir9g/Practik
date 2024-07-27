package com.bank.Repository;

import com.bank.DB.CreationReasonEntity;
import com.bank.DB.InfoTypeCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface InfoTypeCodeRepository extends JpaRepository<InfoTypeCodeEntity, BigInteger> {
    Optional<InfoTypeCodeEntity> findByName(String name);
}
