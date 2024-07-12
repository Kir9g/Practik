package com.bank.Repository;

import com.bank.DB.RstrListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface RstrListRepository extends JpaRepository<RstrListEntity, BigInteger> {
}
