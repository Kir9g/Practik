package com.bank.Service;


import com.bank.DB.*;
import com.bank.DTO.Models.*;
import com.bank.Repository.AccRstrRepository;
import com.bank.Repository.AccountStatusRepository;
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
public class AccountStatusService {

    @Autowired
    private AccountStatusRepository repository;

    @Transactional
    public AccountStatusDTO create(AccountStatusDTO dto) {
        var entity = new AccountStatusEntity();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        repository.save(entity);
        return convertToDTO(entity);
    }

    @Transactional
    public List<AccountStatusDTO> getAll() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public AccountStatusDTO getById(BigInteger id) {
        return repository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Transactional
    public AccountStatusDTO update(BigInteger id, AccountStatusDTO dto) {
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
    public AccountStatusDTO getByName(String name) {
        var entity = repository.findByName(name);
        var dto = convertToDTO(entity);
        if(dto!=null){
            return dto;
        }else {
            return null;
        }
    }

    private AccountStatusDTO convertToDTO(AccountStatusEntity entity) {
        var dto = new AccountStatusDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }
}
