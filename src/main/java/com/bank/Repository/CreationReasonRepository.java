package com.bank.Repository;

import com.bank.DB.CreationReasonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface CreationReasonRepository extends JpaRepository<CreationReasonEntity, BigInteger> {
    Optional<CreationReasonEntity> findByName(String name);
}
