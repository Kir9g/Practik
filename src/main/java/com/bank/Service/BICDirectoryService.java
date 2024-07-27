package com.bank.Service;

import com.bank.DB.BICDirectoryEntry;
import com.bank.DB.ED807Entity;
import com.bank.DTO.Models.BicDirectoryDTO;
import com.bank.DTO.ru.cbr.ed.v2.BICDirectoryEntryType;
import com.bank.Repository.BICDirectoryEntity;
import com.bank.Repository.ChangeTypeRepository;
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
    @Autowired
    private ChangeTypeRepository changeTypeRepository;
    @Transactional
    public BICDirectoryEntry updateBIC(BigInteger id, BicDirectoryDTO bicDirectoryDTO) {
        Optional<BICDirectoryEntry> bicDirectoryEntity = bicDirectoryRep.findById(id);
        BICDirectoryEntry bicDirectoryResult = bicDirectoryEntity.get();
        if(bicDirectoryDTO.getBIC() != null) {
            bicDirectoryResult.setBIC(bicDirectoryDTO.getBIC());
        }
        if(bicDirectoryDTO.getChangeType() != null) {
            bicDirectoryResult.setChangeType(changeTypeRepository.findByName(bicDirectoryDTO.getChangeType()));
        }
        return bicDirectoryRep.save(bicDirectoryResult);
    }
    @Transactional
    public BICDirectoryEntry createBIC(ED807Entity entity,BicDirectoryDTO bicDirectoryDTO){
        BICDirectoryEntry bicDirectoryEntry = new BICDirectoryEntry();
        bicDirectoryEntry.setEd807Entity(entity);
        bicDirectoryEntry.setBIC(bicDirectoryEntry.getBIC());
        if (bicDirectoryDTO.getChangeType() != null) {
            bicDirectoryEntry.setChangeType(changeTypeRepository.findByName(bicDirectoryDTO.getChangeType()));
        } else {
            bicDirectoryEntry.setChangeType(null);
        }
        entity.addBicDirectoryEntries(bicDirectoryEntry);
        return bicDirectoryRep.save(bicDirectoryEntry);
    }
}
