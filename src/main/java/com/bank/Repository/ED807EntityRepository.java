package com.bank.Repository;

import com.bank.DB.ED807Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;


@Repository
public interface ED807EntityRepository extends JpaRepository<ED807Entity, BigInteger> {
    List<ED807Entity> findByName(String name);
}

