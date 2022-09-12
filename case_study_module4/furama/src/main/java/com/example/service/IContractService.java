package com.example.service;

import com.example.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<Contract> findAll(String keyword, Pageable pageable);
    Contract findById(Integer id);
}
