package com.bank.Repository;

import com.bank.DB.XchTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface XchTypeRepository extends JpaRepository<XchTypeEntity, BigInteger> {

    XchTypeEntity findByName(Integer name);
}
