package com.bank.Service;


import com.bank.DB.RstrEntity;
import com.bank.DB.XchTypeEntity;
import com.bank.DTO.Models.RstrDTO;
import com.bank.DTO.Models.XchTypeDTO;
import com.bank.Repository.RstrRepository;
import com.bank.Repository.XchTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RstrService {

    @Autowired
    private RstrRepository repository;

    @Transactional
    public RstrDTO createRstr(RstrDTO dto) {
        var entity = new RstrEntity();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        repository.save(entity);
        return convertToDTO(entity);
    }

    @Transactional
    public List<RstrDTO> getRstrAll() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public RstrDTO getRstrById(BigInteger id) {
        return repository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Transactional
    public RstrDTO updateRstr(BigInteger id, RstrDTO dto) {
        return repository.findById(id)
                .map(entity -> {
                    entity.setName(dto.getName());
                    entity.setDescription(dto.getDescription());
                    return convertToDTO(repository.save(entity));
                }).orElse(null);
    }

    @Transactional
    public void deleteRstr(BigInteger id) {
        repository.deleteById(id);
    }

    @Transactional
    public RstrDTO getRstrByName(String name) {
        var entity = repository.findByName(name);
        var dto = convertToDTO(entity);
        if(dto!=null){
            return dto;
        }else {
            return null;
        }
    }

    private RstrDTO convertToDTO(RstrEntity entity) {
        var dto = new RstrDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }
}
