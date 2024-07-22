package com.bank.Service;

import com.bank.DB.BICDirectoryEntry;
import com.bank.DB.ED807Entity;
import com.bank.DB.PartInfoEntity;
import com.bank.DB.SWBICSEntity;
import com.bank.DTO.ru.cbr.ed.v2.PartInfo;
import com.bank.DTO.ru.cbr.ed.v2.SWBICList;
import com.bank.Repository.BICDirectoryEntity;
import com.bank.Repository.PartInfoRepository;
import com.bank.Repository.SWBICSRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;
@Service
public class SWBICSService {
    @Autowired
    private SWBICSRepository swbicsRepository;
    @Autowired
    private BICDirectoryEntity bicDirectoryEntity;
    @Transactional
    public SWBICSEntity updateSwbic(BigInteger id, SWBICList swbicList){
        Optional<SWBICSEntity> swbics = swbicsRepository.findById(id);
        if(swbics!=null){
            SWBICSEntity swbicsEntity = swbics.get();
            if(swbicList.getSWBIC()!=null) {
                swbicsEntity.setSWBIC(swbicList.getSWBIC());
            }
            if (swbicList.isDefaultSWBIC() != null){
                swbicsEntity.setDefaultSWBIC(swbicList.isDefaultSWBIC());
            }
            return swbicsRepository.save(swbicsEntity);
        }else {
            return null;
        }
    }
    @Transactional
    public SWBICSEntity createSwbic(BICDirectoryEntry bicDirectoryEntry, SWBICList swbicList){
        SWBICSEntity swbicsEntity = new SWBICSEntity();
        if(swbicList.isDefaultSWBIC()!=null) {
            swbicsEntity.setDefaultSWBIC(swbicList.isDefaultSWBIC());
        }
        if(swbicList.getSWBIC()!=null){
            swbicsEntity.setSWBIC(swbicList.getSWBIC());
        }
        swbicsEntity.setBicDirectoryEntry(bicDirectoryEntry);
        bicDirectoryEntry.addSwbics(swbicsEntity);

        swbicsRepository.save(swbicsEntity);
        bicDirectoryEntity.save(bicDirectoryEntry);
        return swbicsEntity;
    }
}
