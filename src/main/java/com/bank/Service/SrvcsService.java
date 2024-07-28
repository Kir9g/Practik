package com.bank.Service;

import com.bank.DB.SrvcsEntity;

import com.bank.DTO.Models.SrvcsDTO;
import com.bank.Repository.SrvcsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SrvcsService {

    @Autowired
    private SrvcsRepository srvcsRepository;

    @Transactional
    public SrvcsDTO createSrvcs(SrvcsDTO srvcsDTO) {
        SrvcsEntity entity = new SrvcsEntity();
        entity.setName(srvcsDTO.getName());
        entity.setDescription(srvcsDTO.getDescription());
        srvcsRepository.save(entity);
        return convertToDTO(entity);
    }

    @Transactional
    public List<SrvcsDTO> getAllSrvcs() {
        return srvcsRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public SrvcsDTO getSrvcsById(BigInteger id) {
        return srvcsRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Transactional
    public SrvcsDTO updateSrvcs(BigInteger id, SrvcsDTO srvcsDTO) {
        return srvcsRepository.findById(id)
                .map(entity -> {
                    entity.setName(srvcsDTO.getName());
                    entity.setDescription(srvcsDTO.getDescription());
                    return convertToDTO(srvcsRepository.save(entity));
                }).orElse(null);
    }

    @Transactional
    public void deleteSrvcs(BigInteger id) {
        srvcsRepository.deleteById(id);
    }

    @Transactional
    public SrvcsDTO getSrvcsByName(Integer name) {
        SrvcsEntity entity = srvcsRepository.findByName(name);
        SrvcsDTO dto =convertToDTO(entity);
        if(dto!=null){
            return dto;
        }else {
            return null;
        }
    }

    private SrvcsDTO convertToDTO(SrvcsEntity entity) {
        SrvcsDTO dto = new SrvcsDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }
}
