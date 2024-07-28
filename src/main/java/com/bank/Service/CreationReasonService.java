package com.bank.Service;

import com.bank.DB.CreationReasonEntity;
import com.bank.DTO.Models.CreationReasonDTO;
import com.bank.Repository.CreationReasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CreationReasonService {

    @Autowired
    private CreationReasonRepository creationReasonRepository;

    @Transactional
    public CreationReasonDTO createCreationReason(CreationReasonDTO creationReasonDTO) {
        CreationReasonEntity entity = new CreationReasonEntity();
        entity.setName(creationReasonDTO.getName());
        entity.setDescription(creationReasonDTO.getDescription());
        creationReasonRepository.save(entity);
        return convertToDTO(entity);
    }

    @Transactional
    public List<CreationReasonDTO> getAllCreationReasons() {
        return creationReasonRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public CreationReasonDTO getCreationReasonById(BigInteger id) {
        return creationReasonRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }
    @Transactional
    public CreationReasonDTO getCreationReasonByName(String name) {
        Optional<CreationReasonEntity> entity = creationReasonRepository.findByName(name);
        return entity.map(this::convertToDTO).orElse(null);
    }

    @Transactional
    public CreationReasonDTO updateCreationReason(BigInteger id, CreationReasonDTO creationReasonDTO) {
        return creationReasonRepository.findById(id)
                .map(entity -> {
                    entity.setName(creationReasonDTO.getName());
                    entity.setDescription(creationReasonDTO.getDescription());
                    return convertToDTO(creationReasonRepository.save(entity));
                }).orElse(null);
    }

    @Transactional
    public void deleteCreationReason(BigInteger id) {
        creationReasonRepository.deleteById(id);
    }

    private CreationReasonDTO convertToDTO(CreationReasonEntity entity) {
        CreationReasonDTO dto = new CreationReasonDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }

}