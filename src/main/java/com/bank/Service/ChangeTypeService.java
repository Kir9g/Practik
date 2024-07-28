package com.bank.Service;

import com.bank.DB.ChangeTypeEntity;

import com.bank.DTO.Models.ChangeTypeDTO;
import com.bank.Repository.ChangeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChangeTypeService{

    @Autowired
    private ChangeTypeRepository changeTypeRepository;

    @Transactional
    public ChangeTypeDTO createChangeType(ChangeTypeDTO changeTypeDTO) {
        ChangeTypeEntity entity = new ChangeTypeEntity();
        entity.setName(changeTypeDTO.getName());
        entity.setDescription(changeTypeDTO.getDescription());
        changeTypeRepository.save(entity);
        return convertToDTO(entity);
    }

    @Transactional
    public List<ChangeTypeDTO> getAllChangeTypes() {
        return changeTypeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public ChangeTypeDTO getChangeTypeById(BigInteger id) {
        return changeTypeRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Transactional
    public ChangeTypeDTO updateChangeType(BigInteger id, ChangeTypeDTO changeTypeDTO) {
        return changeTypeRepository.findById(id)
                .map(entity -> {
                    entity.setName(changeTypeDTO.getName());
                    entity.setDescription(changeTypeDTO.getDescription());
                    return convertToDTO(changeTypeRepository.save(entity));
                }).orElse(null);
    }

    @Transactional
    public void deleteChangeType(BigInteger id) {
        changeTypeRepository.deleteById(id);
    }

    @Transactional
    public ChangeTypeDTO getChangeTypeByName(String name) {
        ChangeTypeEntity entity = changeTypeRepository.findByName(name);
        ChangeTypeDTO dto= convertToDTO(entity);
        if(dto!=null) {
            return dto;
        }else {
            return null;
        }
    }

    private ChangeTypeDTO convertToDTO(ChangeTypeEntity entity) {
        ChangeTypeDTO dto = new ChangeTypeDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }

}