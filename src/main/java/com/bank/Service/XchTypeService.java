package com.bank.Service;


import com.bank.DB.XchTypeEntity;
import com.bank.DTO.Models.XchTypeDTO;
import com.bank.Repository.XchTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class XchTypeService {

    @Autowired
    private XchTypeRepository repository;

    @Transactional
    public XchTypeDTO createXch(XchTypeDTO xchTypeDTO) {
        XchTypeEntity entity = new XchTypeEntity();
        entity.setName(xchTypeDTO.getName());
        entity.setDescription(xchTypeDTO.getDescription());
        repository.save(entity);
        return convertToDTO(entity);
    }

    @Transactional
    public List<XchTypeDTO> getAllXch() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public XchTypeDTO getXchById(BigInteger id) {
        return repository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Transactional
    public XchTypeDTO updateXch(BigInteger id, XchTypeDTO dto) {
        return repository.findById(id)
                .map(entity -> {
                    entity.setName(dto.getName());
                    entity.setDescription(dto.getDescription());
                    return convertToDTO(repository.save(entity));
                }).orElse(null);
    }

    @Transactional
    public void deleteXch(BigInteger id) {
        repository.deleteById(id);
    }

    @Transactional
    public XchTypeDTO getXchByName(Integer name) {
        XchTypeEntity entity = repository.findByName(name);
        XchTypeDTO dto =convertToDTO(entity);
        if(dto!=null){
            return dto;
        }else {
            return null;
        }
    }

    private XchTypeDTO convertToDTO(XchTypeEntity entity) {
        XchTypeDTO dto = new XchTypeDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }
}
