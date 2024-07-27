package com.bank.utils;

import com.bank.DB.AccRstrEntity;
import com.bank.DB.ChangeTypeEntity;
import com.bank.DB.RegulationAccountTypeEntity;
import com.bank.Repository.AccRstrRepository;
import com.bank.Repository.ChangeTypeRepository;
import com.bank.Repository.RegulationAccountTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RegulationAccountTypeUtilis implements CommandLineRunner {
    @Autowired
    private RegulationAccountTypeRepository repository;

    @Override
    public void run(String... args) throws Exception {
        createRegAccType("CBRA","Счет Банка России");
        createRegAccType("CRSA","Корреспондентский счет (субсчет)");
        createRegAccType("BANA","Банковский счет, не являющийся\n" +
                "корреспондентским счетом (субсчетом)\n" +
                "или единым казначейским счетом");
        createRegAccType("TRSA","Счет территориального органа\n" +
                "Федерального казначейства\n");
        createRegAccType("TRUA","Счет доверительного управления");
        createRegAccType("CLAC","Клиринговый счет");
        createRegAccType("UTRA","Единый казначейский счет");
    }

    private void createRegAccType(String name,String description) {
        if (repository.findByName(name) == null) {
            RegulationAccountTypeEntity entity = new RegulationAccountTypeEntity();
            entity.setName(name);
            entity.setDescription(description);
            repository.save(entity);
        }else {
            System.out.println("info");
        }
    }
}
