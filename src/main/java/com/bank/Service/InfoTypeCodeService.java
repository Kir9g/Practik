package com.bank.Service;
import com.bank.DB.InfoTypeCodeEntity;

import com.bank.DTO.Models.InfoTypeCodeDTO;
import com.bank.Repository.InfoTypeCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InfoTypeCodeService {

    @Autowired
    private InfoTypeCodeRepository infoTypeCodeRepository;

    @Transactional
    public InfoTypeCodeDTO createInfoTypeCode(InfoTypeCodeDTO infoTypeCodeDTO) {
        InfoTypeCodeEntity entity = new InfoTypeCodeEntity();
        entity.setName(infoTypeCodeDTO.getName());
        entity.setDescription(infoTypeCodeDTO.getDescription());
        entity = infoTypeCodeRepository.save(entity);
        return convertToDTO(entity);
    }

    @Transactional
    public List<InfoTypeCodeDTO> getAllInfoTypeCodes() {
        return infoTypeCodeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public InfoTypeCodeDTO getInfoTypeCodeById(BigInteger id) {
        return infoTypeCodeRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Transactional
    public InfoTypeCodeDTO updateInfoTypeCode(BigInteger id, InfoTypeCodeDTO infoTypeCodeDTO) {
        return infoTypeCodeRepository.findById(id)
                .map(entity -> {
                    entity.setName(infoTypeCodeDTO.getName());
                    entity.setDescription(infoTypeCodeDTO.getDescription());
                    return convertToDTO(infoTypeCodeRepository.save(entity));
                }).orElse(null);
    }

    @Transactional
    public void deleteInfoTypeCode(BigInteger id) {
        infoTypeCodeRepository.deleteById(id);
    }

    @Transactional
    public InfoTypeCodeDTO getInfoTypeCodeByName(String name) {
        Optional<InfoTypeCodeEntity> entity = infoTypeCodeRepository.findByName(name);
        return entity.map(this::convertToDTO).orElse(null);
    }

    private InfoTypeCodeDTO convertToDTO(InfoTypeCodeEntity entity) {
        InfoTypeCodeDTO dto = new InfoTypeCodeDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }

}