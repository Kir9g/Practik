package com.bank.utils;

import com.bank.DB.ChangeTypeEntity;
import com.bank.DB.CreationReasonEntity;
import com.bank.DB.InfoTypeCodeEntity;
import com.bank.Repository.ChangeTypeRepository;
import com.bank.Repository.CreationReasonRepository;
import com.bank.Repository.InfoTypeCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ChangeTypeUtilis implements CommandLineRunner {
    @Autowired
    private ChangeTypeRepository changeTypeRepository;

    @Override
    public void run(String... args) throws Exception {
        createChangeType("ADDD","Запись Справочника БИК была добавлена");
        createChangeType("CHGD","Запись Справочника БИК была\n" +
                "изменена по сравнению с предыдущей\n" +
                "версией Справочника(под изменением\n" +
                "понимается любое изменение\n" +
                "информации, относящейся к участнику.\n" +
                "В том числе: добавление, удаление,\n" +
                "изменение характеристик счета\n" +
                "участника)\n");
        createChangeType("DLTD","Запись Справочника БИК была удалена");
    }

    private void createChangeType(String name,String description) {
        if (changeTypeRepository.findByName(name) == null) {
            ChangeTypeEntity entity = new ChangeTypeEntity();
            entity.setName(name);
            entity.setDescription(description);
            changeTypeRepository.save(entity);
        }else {
            System.out.println("info");
        }
    }
}

