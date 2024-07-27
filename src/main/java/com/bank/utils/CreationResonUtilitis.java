package com.bank.utils;

import com.bank.DB.CreationReasonEntity;
import com.bank.Repository.CreationReasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CreationResonUtilitis implements CommandLineRunner {
    @Autowired
    private CreationReasonRepository creationReasonRepository;

    @Override
    public void run(String... args) throws Exception {
        createCreationReason("RQST","Ответ на ЭС-запрос Участника");
        createCreationReason("CIBD", "Регламентное направление изменений" +
                "в Справочнике БИК в течение" +
                "операционного дня.");
        createCreationReason("FCBD","1) Регламентное направление" +
                "изменений к Справочнику БИК," +
                "формируемого в завершающем сеансе" +
                "операционного дня платежной системы" +
                "Банка России, актуальных со" +
                "следующего операционного дня (SIRR);" +
                "2) Регламентное направление из" +
                "ПС СБП в ОПКЦ полного Справочника БИК, формируемого в завершающем " +
                "сеансе операционного дня платежной системы Банка России, актуального со следующего операционного дня (FIRR).");
    }

    private void createCreationReason(String name,String description) {
        Optional<CreationReasonEntity> creationReasonName = creationReasonRepository.findByName(name);
        if (creationReasonName.isEmpty()) {
            CreationReasonEntity creationReason = new CreationReasonEntity();
            creationReason.setName(name);
            creationReason.setDescription(description);
            creationReasonRepository.save(creationReason);
        }else {
            System.out.println("WYYYYY");
        }
    }
}
