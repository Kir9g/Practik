package com.bank.Repository;

import com.bank.DB.ED807Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;


@Repository
public interface ED807EntityRepository extends JpaRepository<ED807Entity, BigInteger> {

}
