package com.bank.utils;

import com.bank.DB.ChangeTypeEntity;
import com.bank.DB.ParticipantStatusEntity;
import com.bank.Repository.ChangeTypeRepository;
import com.bank.Repository.ParticipantStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ParticipantStatusUtilis implements CommandLineRunner {
    @Autowired
    private ParticipantStatusRepository statusRepository;

    @Override
    public void run(String... args) throws Exception {
        createParticipantStatus("PSAC","«Действующий», когда текущая дата\n" +
                "операционного дня позднее или равна\n" +
                "дате активации участника и ранее даты\n" +
                "удаления Участника, если дата\n" +
                "удаления Участника была установлена");
        createParticipantStatus("PSDL","«Удаленный», если текущая дата\n" +
                "операционного дня равна дате\n" +
                "вступления в силу удаления Участника\n" +
                "(направляется только в «короткой»\n" +
                "версии ED807 содержащей только\n" +
                "изменения в Справочнике БИК. Только в\n" +
                "день удаления)");
    }

    private void createParticipantStatus(String name,String description) {
        if (statusRepository.findByName(name) == null) {
            ParticipantStatusEntity entity = new ParticipantStatusEntity();
            entity.setName(name);
            entity.setDescription(description);
            statusRepository.save(entity);
        }else {
            System.out.println("info");
        }
    }
}
