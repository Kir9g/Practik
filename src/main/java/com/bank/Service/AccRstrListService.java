package com.bank.Service;

import com.bank.DB.AccRstrListEntity;
import com.bank.DB.Accounts;
import com.bank.DB.BICDirectoryEntry;
import com.bank.DTO.ru.cbr.ed.v2.AccRstrListType;
import com.bank.DTO.ru.cbr.ed.v2.AccountsType;
import com.bank.Repository.AccRstrListRepository;
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
    @Transactional
    public AccRstrListEntity updateAccount(BigInteger id, AccRstrListType accRstrListType) {
        Optional<AccRstrListEntity> accRstrList = accRstrListRepository.findById(id);
        if (accRstrList.isPresent()) {
            AccRstrListEntity updateAccRstr = accRstrList.get();
            if (accRstrListType.getAccRstr() != null) {
                updateAccRstr.setAccRstr(accRstrListType.getAccRstr().value());
            }
            if (accRstrListType.getAccRstrDate() != null) {
                updateAccRstr.setAccRstrDate(accRstrListType.getAccRstrDate().toGregorianCalendar().getTime());
            }
            if (accRstrListType.getSuccessorBIC() != null) {
                updateAccRstr.setSuccessorBIC(accRstrListType.getSuccessorBIC());
            }
            return accRstrListRepository.save(updateAccRstr);
        }else {
            return null;
        }
    }
    @Transactional
    public AccRstrListEntity createAcc(Accounts accountsEntity, AccRstrListType accRstrListType){
        AccRstrListEntity accRstrListEntity = new AccRstrListEntity();
        accountsEntity.addAccRstrListEntity(accRstrListEntity);
        accRstrListEntity.setAccounts(accountsEntity);
        accRstrListEntity.setAccRstr(accRstrListType.getAccRstr().value());
        accRstrListEntity.setAccRstrDate(accRstrListType.getAccRstrDate().toGregorianCalendar().getTime());
        if(accRstrListType.getSuccessorBIC()!=null){
            accRstrListEntity.setSuccessorBIC(accRstrListType.getSuccessorBIC());
        }else {accRstrListEntity.setSuccessorBIC(null);}
        accountRepository.save(accountsEntity);
        return accRstrListRepository.save(accRstrListEntity);
    }
}
