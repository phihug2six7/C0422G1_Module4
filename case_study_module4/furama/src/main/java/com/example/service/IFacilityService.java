package com.example.service;

import com.example.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService {
    Page<Facility> findAllFacility(String keyword, Pageable pageable);
    Facility findByIdFacility(Integer id);
    void saveFacility(Facility facility);
    void removeFacility(Integer id);
}
