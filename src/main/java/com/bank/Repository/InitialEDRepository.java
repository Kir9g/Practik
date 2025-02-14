package com.bank.Repository;

import com.bank.DB.InitialED;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface InitialEDRepository extends JpaRepository<InitialED, BigInteger> {
}
