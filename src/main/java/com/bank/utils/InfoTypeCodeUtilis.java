package com.bank.utils;

import com.bank.DB.CreationReasonEntity;
import com.bank.DB.InfoTypeCodeEntity;
import com.bank.Repository.CreationReasonRepository;
import com.bank.Repository.InfoTypeCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class InfoTypeCodeUtilis implements CommandLineRunner {
    @Autowired
    private InfoTypeCodeRepository infoTypeCodeRepository;

    @Override
    public void run(String... args) throws Exception {
        createInfoTypeCode("FIRR","Полный Справочник БИК");
        createInfoTypeCode("SIRR","Изменения в Справочнике БИК " +
                "(содержит только изменения относительно предыдущего Справочника БИК)");
    }

    private void createInfoTypeCode(String name,String description) {
        Optional<InfoTypeCodeEntity> infoTypeCodeEntity = infoTypeCodeRepository.findByName(name);
        if (infoTypeCodeEntity.isEmpty()) {
            InfoTypeCodeEntity infoTypeCode = new InfoTypeCodeEntity();
            infoTypeCode.setName(name);
            infoTypeCode.setDescription(description);
            infoTypeCodeRepository.save(infoTypeCode);
        }else {
            System.out.println("change");
        }
    }
}

