package com.example.repository;

import com.example.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepository extends JpaRepository<Contract,Integer> {
    Page<Contract> findAllByEndDateGreaterThan(String keyword, Pageable pageable);
}
