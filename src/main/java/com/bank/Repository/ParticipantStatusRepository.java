package com.bank.Repository;

import com.bank.DB.ParticipantStatusEntity;
import com.bank.DB.PtTypeEntity;
import com.bank.DTO.ru.cbr.ed.leaftypes.v2.ParticipantStatusType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface ParticipantStatusRepository extends JpaRepository<ParticipantStatusEntity, BigInteger> {
    ParticipantStatusEntity findByName(String name);
}
