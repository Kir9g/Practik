package com.bank.Repository;

import com.bank.DB.ParticipantInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ParticipantInfoRepository extends JpaRepository<ParticipantInfoEntity, BigInteger> {
}
