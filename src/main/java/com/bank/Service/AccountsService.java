package com.bank.Service;

import com.bank.DB.Accounts;
import com.bank.DB.BICDirectoryEntry;
import com.bank.DB.ED807Entity;
import com.bank.Repository.AccountRepository;
import com.bank.Repository.BICDirectoryEntity;
import com.bank.Repository.ED807EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class AccountsService {

    @Autowired
    private AccountRepository accountsRepository;

    @Autowired
    private BICDirectoryEntity bicDirectoryEntity;

    @Autowired
    private ED807EntityRepository ed807EntityRepository;

}
