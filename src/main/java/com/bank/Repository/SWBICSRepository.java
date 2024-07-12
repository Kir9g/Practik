package com.bank.Repository;

import com.bank.DB.SWBICSEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface SWBICSRepository extends JpaRepository<SWBICSEntity, BigInteger> {
}
