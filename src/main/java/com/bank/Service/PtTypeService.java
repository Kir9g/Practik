package com.bank.Service;

import com.bank.DB.PtTypeEntity;

import com.bank.DTO.Models.PtTypeDTO;
import com.bank.Repository.PtTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PtTypeService {

    @Autowired
    private PtTypeRepository ptTypeRepository;

    @Transactional
    public PtTypeDTO createPtType(PtTypeDTO ptTypeDTO) {
        PtTypeEntity entity = new PtTypeEntity();
        entity.setName(ptTypeDTO.getName());
        entity.setDescription(ptTypeDTO.getDescription());
        ptTypeRepository.save(entity);
        return convertToDTO(entity);
    }

    @Transactional
    public List<PtTypeDTO> getAllPtTypes() {
        return ptTypeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public PtTypeDTO getPtTypeById(BigInteger id) {
        return ptTypeRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Transactional
    public PtTypeDTO updatePtType(BigInteger id, PtTypeDTO ptTypeDTO) {
        return ptTypeRepository.findById(id)
                .map(entity -> {
                    entity.setName(ptTypeDTO.getName());
                    entity.setDescription(ptTypeDTO.getDescription());
                    return convertToDTO(ptTypeRepository.save(entity));
                }).orElse(null);
    }

    @Transactional
    public void deletePtType(BigInteger id) {
        ptTypeRepository.deleteById(id);
    }

    @Transactional
    public PtTypeDTO getPtTypeByName(String name) {
        PtTypeEntity entity = ptTypeRepository.findByName(name);
        PtTypeDTO dto = convertToDTO(entity);
        if(dto!=null){
            return dto;
        }else {
            return null;
        }
    }

    private PtTypeDTO convertToDTO(PtTypeEntity entity) {
        PtTypeDTO dto = new PtTypeDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());

        return dto;
    }

}
