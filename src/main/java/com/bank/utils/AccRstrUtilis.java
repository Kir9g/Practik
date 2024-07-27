package com.bank.utils;

import com.bank.DB.AccRstrEntity;
import com.bank.DB.ChangeTypeEntity;
import com.bank.Repository.AccRstrRepository;
import com.bank.Repository.ChangeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AccRstrUtilis implements CommandLineRunner {
    @Autowired
    private AccRstrRepository accRstrRepository;

    @Override
    public void run(String... args) throws Exception {
        createAccRstr("LMRS","Временное сохранение счета с его\n" +
                "функционированием в ограниченном\n" +
                "режиме\n");
        createAccRstr("URRS","Ограничение предоставления сервиса\n" +
                "срочного перевода");
        createAccRstr("CLRS","Закрытие счета");
        createAccRstr("FPRS","Приостановление предоставления\n" +
                "сервиса быстрых платежей");
        createAccRstr("SDRS","Признак использования реквизитов\n" +
                "филиала кредитной организации после его преобразования во внутреннее\n" +
                "структурное подразделение (Признак\n" +
                "ВСП)");
    }

    private void createAccRstr(String name,String description) {
        if (accRstrRepository.findByName(name) == null) {
            AccRstrEntity entity = new AccRstrEntity();
            entity.setName(name);
            entity.setDescription(description);
            accRstrRepository.save(entity);
        }else {
            System.out.println("info");
        }
    }
}
