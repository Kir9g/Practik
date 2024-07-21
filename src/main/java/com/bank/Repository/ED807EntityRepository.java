package com.bank.Repository;

import com.bank.DB.ED807Entity;
import com.bank.DB.InitialED;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface ED807EntityRepository extends JpaRepository<ED807Entity, BigInteger> {
    List<ED807Entity> findByName(String name);


    @Query("SELECT e FROM ED807Entity e WHERE e.CreationDate BETWEEN :startDate AND :endDate")
    List<ED807Entity> findAllByCreationDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    Optional<ED807Entity> findByInitialED(InitialED initialED);
}

