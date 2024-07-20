package com.bank.Service;

import com.bank.DB.PartInfoEntity;
import com.bank.DTO.ru.cbr.ed.v2.PartInfo;
import com.bank.Repository.PartInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class PartInfoSerivce {
    @Autowired
    private PartInfoRepository partInfoRepository;
    public PartInfoEntity updatePartInfo(BigInteger id,PartInfo partInfo){
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
            return partInfoRepository.save(partInfoEntity1);
        }else {
            return null;
        }
    }
}
