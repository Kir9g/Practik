package com.bank.Repository;

import com.bank.DB.PartInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface PartInfoRepository extends JpaRepository<PartInfoEntity, BigInteger> {

}
