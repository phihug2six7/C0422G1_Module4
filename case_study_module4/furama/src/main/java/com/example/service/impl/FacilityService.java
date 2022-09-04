package com.example.service.impl;

import com.example.model.Facility;
import com.example.repository.IFacilityRepository;
import com.example.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository iFacilityRepository;

    @Override
    public Page<Facility> findAllFacility(String keyword, Pageable pageable) {
        return iFacilityRepository.findAllByNameContaining(keyword,pageable);
    }

    @Override
    public Facility findByIdFacility(Integer id) {
        return iFacilityRepository.findById(id).orElse(new Facility());
    }

    @Override
    public void saveFacility(Facility facility) {
        iFacilityRepository.save(facility);
    }

    @Override
    public void removeFacility(Integer id) {
        iFacilityRepository.deleteById(id);
    }
}
