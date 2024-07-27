package com.bank.Repository;

import com.bank.DB.AccRstrEntity;
import com.bank.DB.AccountStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface AccountStatusRepository extends JpaRepository<AccountStatusEntity, BigInteger> {
    AccountStatusEntity findByName(String name);
}
