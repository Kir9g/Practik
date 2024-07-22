package com.bank.Service;

import com.bank.DB.ED807Entity;
import com.bank.DB.InitialED;
import com.bank.DB.PartInfoEntity;
import com.bank.DTO.ru.cbr.ed.v2.InitialEDInfo;
import com.bank.DTO.ru.cbr.ed.v2.PartInfo;
import com.bank.Repository.ED807EntityRepository;
import com.bank.Repository.PartInfoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class PartInfoSerivce {
    @Autowired
    private PartInfoRepository partInfoRepository;
    @Autowired
    private ED807EntityRepository ed807EntityRepository;
    public ED807Entity updatePartInfo(BigInteger id, PartInfo partInfo){
        Optional<PartInfoEntity> partInfoEntity = partInfoRepository.findById(id);
        if(partInfoEntity!=null){
            PartInfoEntity partInfoEntity1 = partInfoEntity.get();
            if(partInfo.getPartQuantity()!=null) {
                partInfoEntity1.setPartQuantity(partInfo.getPartQuantity());
            }
            if(partInfo.getPartNo()!=null) {
                partInfoEntity1.setPartNo(partInfo.getPartNo());
            }
            if(partInfo.getPartAggregateID()!=null) {
                partInfoEntity1.setPartAggregateID(partInfo.getPartAggregateID());
            }
            partInfoRepository.save(partInfoEntity1);
            return partInfoEntity1.getEd807Entity();
        }else {
            return null;
        }
    }
    @Transactional
    public PartInfoEntity createPart(ED807Entity ed807Entity, PartInfo partInfo){
        PartInfoEntity partInfoEntity = new PartInfoEntity();
        partInfoEntity.setEd807Entity(ed807Entity);
        partInfoEntity.setPartNo(partInfo.getPartNo());
        partInfoEntity.setPartQuantity(partInfo.getPartQuantity());
        partInfoEntity.setPartAggregateID(partInfo.getPartAggregateID());

        partInfoRepository.save(partInfoEntity);
        ed807Entity.setPartInfoEntity(partInfoEntity);
        ed807EntityRepository.save(ed807Entity);
        return partInfoEntity;
    }
}
