package com.bank.Repository;

import com.bank.DB.ParticipantInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantInfoRepository extends JpaRepository<ParticipantInfoEntity, String> {
}
