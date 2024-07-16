package com.bank.Repository;

import com.bank.DB.BICDirectoryEntry;
import com.bank.DB.ED807Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface BICDirectoryEntity extends JpaRepository<BICDirectoryEntry, BigInteger> {

    List<BICDirectoryEntity> findByBIC(String BIC);

}
