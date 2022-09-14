package com.example.repository;

import com.example.model.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IFacilityTypeRepository extends JpaRepository<FacilityType,Integer> {
}
