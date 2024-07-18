package com.bank.Repository;

import com.bank.DB.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface AccountRepository extends JpaRepository<Accounts, BigInteger> {
}
