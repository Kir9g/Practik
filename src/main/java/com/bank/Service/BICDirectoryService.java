package com.bank.Service;

import com.bank.DB.BICDirectoryEntry;
import com.bank.DB.ED807Entity;
import com.bank.DTO.ru.cbr.ed.v2.BICDirectoryEntryType;
import com.bank.Repository.BICDirectoryEntity;
import com.bank.Repository.ED807EntityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BICDirectoryService {
    @Autowired
    private BICDirectoryEntity bicDirectoryRep;
    @Autowired
    private ED807EntityRepository ed807EntityRepository;
    @Transactional
    public BICDirectoryEntry updateBIC(BigInteger id, BICDirectoryEntryType bicDirectoryEntryType) {
        Optional<BICDirectoryEntry> bicDirectoryEntity = bicDirectoryRep.findById(id);
        BICDirectoryEntry bicDirectoryResult = bicDirectoryEntity.get();
        if(bicDirectoryEntryType.getBIC() != null) {
            bicDirectoryResult.setBIC(bicDirectoryEntryType.getBIC());
        }
        if(bicDirectoryEntryType.getChangeType() != null) {
            bicDirectoryResult.setChangeType(bicDirectoryEntryType.getChangeType().value());
        }
        return bicDirectoryRep.save(bicDirectoryResult);
    }
    @Transactional
    public BICDirectoryEntry createBIC(ED807Entity entity,BICDirectoryEntryType bicDirectoryEntryType){
        BICDirectoryEntry bicDirectoryEntry = new BICDirectoryEntry();
        bicDirectoryEntry.setEd807Entity(entity);
        bicDirectoryEntry.setBIC(bicDirectoryEntry.getBIC());
        if (bicDirectoryEntryType.getChangeType() != null) {
            bicDirectoryEntry.setChangeType(bicDirectoryEntryType.getChangeType().value());
        } else {
            bicDirectoryEntry.setChangeType(null);
        }
        entity.addBicDirectoryEntries(bicDirectoryEntry);
        return bicDirectoryRep.save(bicDirectoryEntry);
    }
}
