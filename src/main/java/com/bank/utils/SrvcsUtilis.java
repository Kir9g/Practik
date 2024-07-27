package com.bank.utils;

import com.bank.DB.*;
import com.bank.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SrvcsUtilis implements CommandLineRunner {
    @Autowired
    private SrvcsRepository srvcsRepository;

    @Override
    public void run(String... args) throws Exception {
        createSrvcs(1,"Сервис несрочного перевода");
        createSrvcs(2,"Сервис срочного перевода");
        createSrvcs(3,"Сервис несрочного перевода и сервис срочного перевода");
        createSrvcs(4,"Сервис срочного перевода и сервис быстрых платежей");
        createSrvcs(5,"Сервис срочного перевода, сервис\n" +
                "несрочного перевода и сервис быстрых\n" +
                "платежей");
        createSrvcs(6,"Сервис быстрых платежей");
    }

    private void createSrvcs(Integer name,String description) {
        if (srvcsRepository.findByName(name) == null) {
            SrvcsEntity entity = new SrvcsEntity();
            entity.setName(name);
            entity.setDescription(description);
            srvcsRepository.save(entity);
        }else {
            System.out.println("PtType");
        }
    }
}

