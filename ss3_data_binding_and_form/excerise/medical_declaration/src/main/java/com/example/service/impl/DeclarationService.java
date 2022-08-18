package com.example.service.impl;

import com.example.model.Declaration;
import com.example.repository.IDeclarationRepository;
import com.example.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeclarationService implements IDeclarationService {
    @Autowired
    private IDeclarationRepository iDeclarationRepository;

    @Override
    public List<String> findAllYears() {
        return iDeclarationRepository.findAllYears();
    }

    @Override
    public List<String> findAllGender() {
        return iDeclarationRepository.findAllGender();
    }

    @Override
    public List<String> findALlNation() {
        return iDeclarationRepository.findALlNation();
    }

    @Override
    public List<String> findAllTravelInformation() {
        return iDeclarationRepository.findAllTravelInformation();
    }

    @Override
    public List<String> findAllDayStart() {
        return iDeclarationRepository.findAllDayStart();
    }

    @Override
    public List<String> findAllMonthStart() {
        return iDeclarationRepository.findAllMonthStart();
    }

    @Override
    public List<String> findAllYearsStart() {
        return iDeclarationRepository.findAllYearsStart();
    }

    @Override
    public List<String> findAllDayEnd() {
        return iDeclarationRepository.findAllDayEnd();
    }

    @Override
    public List<String> findAllMonthEnd() {
        return iDeclarationRepository.findAllMonthEnd();
    }

    @Override
    public List<String> findAllYearsEnd() {
        return iDeclarationRepository.findAllYearsEnd();
    }

    @Override
    public List<Declaration> findAll() {
        return iDeclarationRepository.findAll();
    }

    @Override
    public Declaration findById(int id) {
        return iDeclarationRepository.findById(id);
    }

    @Override
    public void create(Declaration declaration) {
        iDeclarationRepository.create(declaration);
    }

    @Override
    public void update(int id, Declaration declaration) {
        iDeclarationRepository.update(id, declaration);
    }
}
