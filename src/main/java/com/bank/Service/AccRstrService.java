package com.bank.Service;


import com.bank.DB.AccRstrEntity;
import com.bank.DB.ParticipantStatusEntity;
import com.bank.DB.RstrEntity;
import com.bank.DB.XchTypeEntity;
import com.bank.DTO.Models.AccRstrDTO;
import com.bank.DTO.Models.ParticipantStatusDTO;
import com.bank.DTO.Models.RstrDTO;
import com.bank.DTO.Models.XchTypeDTO;
import com.bank.Repository.AccRstrRepository;
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
public class AccRstrService {

    @Autowired
    private AccRstrRepository repository;

    @Transactional
    public AccRstrDTO create(AccRstrDTO dto) {
        var entity = new AccRstrEntity();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        repository.save(entity);
        return convertToDTO(entity);
    }

    @Transactional
    public List<AccRstrDTO> getAll() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public AccRstrDTO getById(BigInteger id) {
        return repository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Transactional
    public AccRstrDTO update(BigInteger id, AccRstrDTO dto) {
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
    public AccRstrDTO getByName(String name) {
        var entity = repository.findByName(name);
        var dto = convertToDTO(entity);
        if(dto!=null){
            return dto;
        }else {
            return null;
        }
    }

    private AccRstrDTO convertToDTO(AccRstrEntity entity) {
        var dto = new AccRstrDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }
}
