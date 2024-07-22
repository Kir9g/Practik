package com.bank.Service;

import com.bank.DB.AccRstrListEntity;
import com.bank.DB.ED807Entity;
import com.bank.DB.InitialED;
import com.bank.DTO.ru.cbr.ed.v2.EDRefID;
import com.bank.DTO.ru.cbr.ed.v2.InitialEDInfo;
import com.bank.Repository.ED807EntityRepository;
import com.bank.Repository.InitialEDRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;
@Service
public class InitialEDService {
    @Autowired
    private InitialEDRepository initialEDRepository;
    @Autowired
    private ED807EntityRepository ed807EntityRepository;
    @Transactional
    public InitialED updateInitial(BigInteger id, EDRefID edRefID) {
        InitialED updateInitial = initialEDRepository.findById(id).get();
        if(edRefID.getEDAuthor()!=null){
            updateInitial.setEDAuthor(edRefID.getEDAuthor());
        }
        if(edRefID.getEDNo()!=null){
            updateInitial.setEDNo(edRefID.getEDNo());
        }
        if(edRefID.getEDDate()!=null){
            updateInitial.setEDDate(edRefID.getEDDate().toGregorianCalendar().getTime());
        }
        return initialEDRepository.save(updateInitial);
    }
    @Transactional
    public InitialED createInitial(ED807Entity ed807, InitialEDInfo initialEDInfo){
        InitialED initialED = new InitialED();
        initialED.setEd807Entity(ed807);
        initialED.setEDAuthor(ed807.getInitialED().getEDAuthor());
        initialED.setEDDate(ed807.getInitialED().getEDDate());
        initialED.setEDNo(ed807.getInitialED().getEDNo());

        initialEDRepository.save(initialED);
        ed807.setInitialED(initialED);
        ed807EntityRepository.save(ed807);
        return initialED;
    }
}
