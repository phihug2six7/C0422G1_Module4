package com.example.repository;

import com.example.model.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IRentTypeRepository extends JpaRepository<RentType,Integer> {
}
