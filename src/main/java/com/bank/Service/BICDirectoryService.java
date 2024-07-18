package com.bank.Service;

import com.bank.DB.BICDirectoryEntry;
import com.bank.DB.ED807Entity;
import com.bank.Repository.BICDirectoryEntity;
import com.bank.Repository.ED807EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class BICDirectoryService {
    @Autowired
    private BICDirectoryEntity bicDirectoryEntity;
    @Autowired
    private ED807EntityRepository ed807EntityRepository;
    @Autowired BICDirectoryEntity bicDirectory;

    public BICDirectoryEntry updateBIC(BigInteger id, BICDirectoryEntry bicDirectoryEntry) {
        Optional<ED807Entity> ed807Entitys = ed807EntityRepository.findById(id);
        BICDirectoryEntry bicDirectoryResult = (BICDirectoryEntry) ed807Entitys.get().getBicDirectoryEntries();

        if(bicDirectoryEntry.getBIC() != null) {
            bicDirectoryResult.setBIC(bicDirectoryEntry.getBIC());
        }
        if(bicDirectoryEntry.getChangeType() != null) {
            bicDirectoryResult.setChangeType(bicDirectoryEntry.getChangeType());
        }
        return bicDirectory.save(bicDirectoryResult);
    }
}
