package com.bank.Service;

import com.bank.DB.AccRstrListEntity;
import com.bank.DB.Accounts;
import com.bank.DB.BICDirectoryEntry;
import com.bank.DTO.Models.AccRstrListDTO;
import com.bank.DTO.ru.cbr.ed.v2.AccRstrListType;
import com.bank.DTO.ru.cbr.ed.v2.AccountsType;
import com.bank.Repository.AccRstrListRepository;
import com.bank.Repository.AccRstrRepository;
import com.bank.Repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;
@Service
public class AccRstrListService {
    @Autowired
    private AccRstrListRepository accRstrListRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccRstrRepository accRstrRepository;
    @Transactional
    public AccRstrListEntity updateAccount(BigInteger id, AccRstrListDTO accRstrListDTO) {
        Optional<AccRstrListEntity> accRstrList = accRstrListRepository.findById(id);
        if (accRstrList.isPresent()) {
            AccRstrListEntity updateAccRstr = accRstrList.get();
            if (accRstrListDTO.getAccRstr() != null) {
                updateAccRstr.setAccRstrEntity(accRstrRepository.findByName(accRstrListDTO.getAccRstr()));
            }
            if (accRstrListDTO.getAccRstrDate() != null) {
                updateAccRstr.setAccRstrDate(accRstrListDTO.getAccRstrDate());
            }
            if (accRstrListDTO.getSuccessorBIC() != null) {
                updateAccRstr.setSuccessorBIC(accRstrListDTO.getSuccessorBIC());
            }
            return accRstrListRepository.save(updateAccRstr);
        }else {
            return null;
        }
    }
    @Transactional
    public AccRstrListEntity createAcc(Accounts accountsEntity, AccRstrListDTO accRstrListDTO){
        AccRstrListEntity accRstrListEntity = new AccRstrListEntity();
        accountsEntity.addAccRstrListEntity(accRstrListEntity);
        accRstrListEntity.setAccounts(accountsEntity);
        accRstrListEntity.setAccRstrEntity(accRstrRepository.findByName(accRstrListDTO.getAccRstr()));
        accRstrListEntity.setAccRstrDate(accRstrListDTO.getAccRstrDate());
        if(accRstrListDTO.getSuccessorBIC()!=null){
            accRstrListEntity.setSuccessorBIC(accRstrListDTO.getSuccessorBIC());
        }else {accRstrListEntity.setSuccessorBIC(null);}
        accountRepository.save(accountsEntity);
        return accRstrListRepository.save(accRstrListEntity);
    }
}
