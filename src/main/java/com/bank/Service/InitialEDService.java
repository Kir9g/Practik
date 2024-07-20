package com.bank.Service;

import com.bank.DB.AccRstrListEntity;
import com.bank.DB.InitialED;
import com.bank.DTO.ru.cbr.ed.v2.EDRefID;
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
}
