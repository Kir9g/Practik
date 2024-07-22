package com.bank.Service;

import com.bank.DB.Accounts;
import com.bank.DB.BICDirectoryEntry;
import com.bank.DB.ED807Entity;
import com.bank.DTO.ru.cbr.ed.v2.AccountsType;
import com.bank.DTO.ru.cbr.ed.v2.BICDirectoryEntryType;
import com.bank.DTO.ru.cbr.ed.v2.ED807;
import com.bank.Repository.AccountRepository;
import com.bank.Repository.BICDirectoryEntity;
import com.bank.Repository.ED807EntityRepository;
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
    @Transactional
    public Accounts updateAccount(BigInteger id, AccountsType accountsType) throws Exception {
        Optional<Accounts> accounts = accountsRepository.findById(id);
        Accounts accounts1 = accounts.get();
        if(accountsType.getAccountStatus()!=null){
            accounts1.setAccountStatus(String.valueOf(accountsType.getAccountStatus()));
        }
        if(accountsType.getAccount()!=null){
            accounts1.setAccount(accountsType.getAccount());
        }
        if(accountsType.getAccountCBRBIC()!=null){
            accounts1.setAccountCBRBIC(accountsType.getAccountCBRBIC());
        }
        if(accountsType.getDateOut()!=null){
            accounts1.setDateOut(accountsType.getDateOut().toGregorianCalendar().getTime());
        }
        if(accountsType.getCK()!=null){
            accounts1.setCk(accountsType.getCK());
        }
        if(accountsType.getDateIn()!=null){
            accounts1.setDateIn(accountsType.getDateIn().toGregorianCalendar().getTime());
        }
        if(accountsType.getRegulationAccountType()!=null){
            accounts1.setRegulationAccountType(accountsType.getRegulationAccountType().value());
        }

        return accountsRepository.save(accounts1);
    }

    @Transactional
    public Accounts createAcc(BICDirectoryEntry bicDirectoryEntry, AccountsType accountsType) throws Exception {
        Accounts accountsEntity = new Accounts();
        accountsEntity.setAccount(accountsType.getAccount());
        accountsEntity.setRegulationAccountType(accountsType.getRegulationAccountType().value());
        if(accountsType.getAccount() != null) {
            accountsEntity.setCk(accountsType.getCK());
        }else {accountsEntity.setCk(null);}
        accountsEntity.setAccountCBRBIC(accountsType.getAccountCBRBIC());
        accountsEntity.setDateIn(accountsType.getDateIn().toGregorianCalendar().getTime());
        if(accountsType.getDateOut() != null) {
            accountsEntity.setDateOut(accountsType.getDateOut().toGregorianCalendar().getTime());
        }else {accountsEntity.setDateOut(null);}
        if(accountsType.getAccountStatus() != null){
            accountsEntity.setAccountStatus(String.valueOf(accountsType.getAccountStatus()));
        }else {accountsEntity.setAccountStatus(null);}
        accountsEntity.setBicDirectoryEntry(bicDirectoryEntry);
        bicDirectoryEntry.addAccount(accountsEntity);
        bicDirectoryEntity.save(bicDirectoryEntry);

        return accountsRepository.save(accountsEntity);
    }
}
