package com.bank.Service;

import com.bank.DB.Accounts;
import com.bank.DB.BICDirectoryEntry;
import com.bank.DB.ED807Entity;
import com.bank.DTO.Models.AccountsDTO;
import com.bank.DTO.ru.cbr.ed.v2.AccountsType;
import com.bank.DTO.ru.cbr.ed.v2.BICDirectoryEntryType;
import com.bank.DTO.ru.cbr.ed.v2.ED807;
import com.bank.Repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

@Service
public class AccountsService {

    @Autowired
    private AccountRepository accountsRepository;
    @Autowired
    private BICDirectoryEntity bicDirectoryEntity;
    @Autowired
    private AccountStatusRepository accountStatusRepository;
    @Autowired
    private RegulationAccountTypeRepository regulationAccountTypeRepository;
    @Transactional
    public Accounts updateAccount(BigInteger id, AccountsDTO accountsType) throws Exception {
        Optional<Accounts> accounts = accountsRepository.findById(id);
        Accounts accounts1 = accounts.get();
        if(accountsType.getAccountStatus()!=null){
            accounts1.setAccountStatusEntity(accountStatusRepository.findByName(accountsType.getAccountStatus()));
        }
        if(accountsType.getAccount()!=null){
            accounts1.setAccount(accountsType.getAccount());
        }
        if(accountsType.getAccountCBRBIC()!=null){
            accounts1.setAccountCBRBIC(accountsType.getAccountCBRBIC());
        }
        if(accountsType.getDateOut()!=null){
            accounts1.setDateOut(accountsType.getDateOut());
        }
        if(accountsType.getCk()!=null){
            accounts1.setCk(accountsType.getCk());
        }
        if(accountsType.getDateIn()!=null){
            accounts1.setDateIn(accountsType.getDateIn());
        }
        if(accountsType.getRegulationAccountType()!=null){
            accounts1.setRegulationAccountType(regulationAccountTypeRepository.findByName(accountsType.getRegulationAccountType()));
        }

        return accountsRepository.save(accounts1);
    }

    @Transactional
    public Accounts createAcc(BICDirectoryEntry bicDirectoryEntry, AccountsDTO accountsType) throws Exception {
        Accounts accountsEntity = new Accounts();
        accountsEntity.setAccount(accountsType.getAccount());
        accountsEntity.setRegulationAccountType(regulationAccountTypeRepository.findByName(accountsType.getRegulationAccountType()));
        if(accountsType.getAccount() != null) {
            accountsEntity.setCk(accountsType.getCk());
        }else {accountsEntity.setCk(null);}
        accountsEntity.setAccountCBRBIC(accountsType.getAccountCBRBIC());
        accountsEntity.setDateIn(accountsType.getDateIn());
        if(accountsType.getDateOut() != null) {
            accountsEntity.setDateOut(accountsType.getDateOut());
        }else {accountsEntity.setDateOut(null);}
        if(accountsType.getAccountStatus() != null){
            accountsEntity.setAccountStatusEntity(accountStatusRepository.findByName(accountsType.getAccountStatus()));
        }else {accountsEntity.setAccountStatusEntity(null);}
        accountsEntity.setBicDirectoryEntry(bicDirectoryEntry);
        bicDirectoryEntry.addAccount(accountsEntity);
        bicDirectoryEntity.save(bicDirectoryEntry);

        return accountsRepository.save(accountsEntity);
    }
}
