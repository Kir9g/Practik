package com.bank.Repository;

import com.bank.DB.AccRstrListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccRstrListRepository extends JpaRepository<AccRstrListEntity, String> {
}
