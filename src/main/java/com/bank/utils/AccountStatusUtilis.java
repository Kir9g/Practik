package com.bank.utils;

import com.bank.DB.AccRstrEntity;
import com.bank.DB.AccountStatusEntity;
import com.bank.Repository.AccRstrRepository;
import com.bank.Repository.AccountStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AccountStatusUtilis implements CommandLineRunner {
    @Autowired
    private AccountStatusRepository accountStatusRepository;

    @Override
    public void run(String... args) throws Exception {
        createAccountStatus("ACAC","«Действующий», когда текущая дата\n" +
                "операционного дня позднее или равна\n" +
                "дате активации счета и ранее даты\n" +
                "удаления счета, или если дата\n" +
                "удаления счета не была установлена");
        createAccountStatus("ACDL","«Удаленный», когда текущая дата\n" +
                "операционного дня равна дате\n" +
                "удаления счета\n");
    }

    private void createAccountStatus(String name,String description) {
        if (accountStatusRepository.findByName(name) == null) {
            AccountStatusEntity entity = new AccountStatusEntity();
            entity.setName(name);
            entity.setDescription(description);
            accountStatusRepository.save(entity);
        }else {
            System.out.println("info");
        }
    }
}
