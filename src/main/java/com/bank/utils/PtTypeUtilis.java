package com.bank.utils;

import com.bank.DB.ChangeTypeEntity;
import com.bank.DB.CreationReasonEntity;
import com.bank.DB.InfoTypeCodeEntity;
import com.bank.DB.PtTypeEntity;
import com.bank.Repository.ChangeTypeRepository;
import com.bank.Repository.CreationReasonRepository;
import com.bank.Repository.InfoTypeCodeRepository;
import com.bank.Repository.PtTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PtTypeUtilis implements CommandLineRunner {
    @Autowired
    private PtTypeRepository ptTypeRepository;

    @Override
    public void run(String... args) throws Exception {
        createPtType("00","Главное управление Банка России");
        createPtType("10","Расчетно-кассовый центр");
        createPtType("12","Отделение, отделение – национальный\n" +
                "банк главного управления Банка России");
        createPtType("15","Структурное подразделение\n" +
                "центрального аппарата Банка России");
        createPtType("16","Кассовый центр");
        createPtType("20","Кредитная организация");
        createPtType("30","Филиал кредитной организации");
        createPtType("40","Полевое учреждение Банка России");
        createPtType("51","Федеральное казначейство");
        createPtType("52","Территориальный орган Федерального\n" +
                "казначейства\n");
        createPtType("60","Иностранный банк (иностранная\n" +
                "кредитная организация)\n");
        createPtType("65","Иностранный центральный\n" +
                "(национальный) банк");
        createPtType("71","Клиент кредитной организации,\n" +
                "являющийся косвенным участником");
        createPtType("75","Клиринговая организация");
        createPtType("78","Внешняя платежная система");
        createPtType("90","Конкурсный управляющий (ликвидатор,\n" +
                "ликвидационная комиссия)");
        createPtType("99","Клиент Банка России, не являющийся\n" +
                "участником платежной системы\n");

    }

    private void createPtType(String name,String description) {
        if (ptTypeRepository.findByName(name) == null) {
            PtTypeEntity entity = new PtTypeEntity();
            entity.setName(name);
            entity.setDescription(description);
            ptTypeRepository.save(entity);
        }else {
            System.out.println("PtType");
        }
    }
}

