package com.bank.Repository;

import com.bank.DB.AccRstrListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface AccRstrListRepository extends JpaRepository<AccRstrListEntity, BigInteger> {
}
