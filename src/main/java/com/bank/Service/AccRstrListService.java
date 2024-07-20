package com.bank.Service;

import com.bank.DB.AccRstrListEntity;
import com.bank.DB.Accounts;
import com.bank.DTO.ru.cbr.ed.v2.AccRstrListType;
import com.bank.Repository.AccRstrListRepository;
import com.bank.Repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.Optional;

public class AccRstrListService {
    @Autowired
    private AccRstrListRepository accRstrListRepository;
    @Transactional
    public AccRstrListEntity updateAccount(BigInteger id, AccRstrListType accRstrListType) {
    Optional<AccRstrListEntity> accRstrList = accRstrListRepository.findById(id);
    AccRstrListEntity updateAccRstr = accRstrList.get();
    if(accRstrListType.getAccRstr() != null){
        updateAccRstr.setAccRstr(accRstrListType.getAccRstr().value());
    }
    if(accRstrListType.getAccRstrDate()!=null){
        updateAccRstr.setAccRstrDate(accRstrListType.getAccRstrDate().toGregorianCalendar().getTime());
    }
    if(accRstrListType.getSuccessorBIC()!= null){
        updateAccRstr.setSuccessorBIC(accRstrListType.getSuccessorBIC());
    }
    return accRstrListRepository.save(updateAccRstr);
    }
}
