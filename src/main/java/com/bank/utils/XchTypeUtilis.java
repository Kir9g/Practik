package com.bank.utils;

import com.bank.DB.SrvcsEntity;
import com.bank.DB.XchTypeEntity;
import com.bank.Repository.SrvcsRepository;
import com.bank.Repository.XchTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class XchTypeUtilis implements CommandLineRunner {
    @Autowired
    private XchTypeRepository xchTypeRepository;

    @Override
    public void run(String... args) throws Exception {
        createSrvcs(0, "Не участник обмена");
        createSrvcs(1, "Участник обмена");
    }

    private void createSrvcs(Integer name, String description) {
        if (xchTypeRepository.findByName(name) == null) {
            XchTypeEntity entity = new XchTypeEntity();
            entity.setName(name);
            entity.setDescription(description);
            xchTypeRepository.save(entity);
        } else {
            System.out.println("XchType");
        }
    }
}
