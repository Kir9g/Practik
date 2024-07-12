package com.bank.Repository;

import com.bank.DB.BICDirectoryEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BICDirectoryEntity extends JpaRepository<BICDirectoryEntry,String> {
}
