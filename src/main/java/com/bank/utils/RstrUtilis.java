package com.bank.utils;

import com.bank.DB.CreationReasonEntity;
import com.bank.DB.RstrEntity;
import com.bank.Repository.CreationReasonRepository;
import com.bank.Repository.RstrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RstrUtilis implements CommandLineRunner {
    @Autowired
    private RstrRepository repository;

    @Override
    public void run(String... args) throws Exception {
        createRstr("URRS","Ограничение предоставления сервиса срочного перевода");
        createRstr("LWRS", "Отзыв (аннулирование) лицензии");
        createRstr("FCBD","Мораторий на удовлетворение требований кредиторов");
        createRstr("RSIP","Приостановление доступа к услугам по переводу денежных средств в качестве косвенного участника");
        createRstr("FPIP","Приостановление предоставления сервиса быстрых платежей косвенному участнику");
    }

    private void createRstr(String name,String description) {
        if (repository.findByName(name) == null) {
            RstrEntity creationReason = new RstrEntity();
            creationReason.setName(name);
            creationReason.setDescription(description);
            repository.save(creationReason);
        }else {
            System.out.println("WYYYYY");
        }
    }
}
