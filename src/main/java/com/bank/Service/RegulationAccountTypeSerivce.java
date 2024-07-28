package com.bank.Service;


import com.bank.DB.*;
import com.bank.DTO.Models.*;
import com.bank.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RegulationAccountTypeSerivce {

    @Autowired
    private RegulationAccountTypeRepository repository;

    @Transactional
    public RegulationAccountTypeDTO create(RegulationAccountTypeDTO dto) {
        var entity = new RegulationAccountTypeEntity();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        repository.save(entity);
        return convertToDTO(entity);
    }

    @Transactional
    public List<RegulationAccountTypeDTO> getAll() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public RegulationAccountTypeDTO getById(BigInteger id) {
        return repository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Transactional
    public RegulationAccountTypeDTO update(BigInteger id, RegulationAccountTypeDTO dto) {
        return repository.findById(id)
                .map(entity -> {
                    entity.setName(dto.getName());
                    entity.setDescription(dto.getDescription());
                    return convertToDTO(repository.save(entity));
                }).orElse(null);
    }

    @Transactional
    public void delete(BigInteger id) {
        repository.deleteById(id);
    }

    @Transactional
    public RegulationAccountTypeDTO getByName(String name) {
        var entity = repository.findByName(name);
        var dto = convertToDTO(entity);
        if(dto!=null){
            return dto;
        }else {
            return null;
        }
    }

    private RegulationAccountTypeDTO convertToDTO(RegulationAccountTypeEntity entity) {
        var dto = new RegulationAccountTypeDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }
}
