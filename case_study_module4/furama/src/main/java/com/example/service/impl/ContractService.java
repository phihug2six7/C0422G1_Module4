package com.example.service.impl;

import com.example.model.Contract;
import com.example.repository.IContractRepository;
import com.example.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;
    @Override
    public Page<Contract> findAll(String keyword, Pageable pageable) {
        return iContractRepository.findAllByEndDateGreaterThan(keyword,pageable);
    }
}
