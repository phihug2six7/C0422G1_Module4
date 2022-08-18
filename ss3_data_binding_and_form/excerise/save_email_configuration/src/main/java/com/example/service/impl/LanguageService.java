package com.example.service.impl;

import com.example.repository.ILanguageRepository;
import com.example.service.ILanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LanguageService implements ILanguageService {
    @Autowired
    private ILanguageRepository iLanguageRepository;
    @Override
    public List<String> findAllLanguage() {
        return iLanguageRepository.findAllLanguage();
    }

    @Override
    public List<String> findAllPageSize() {
        return iLanguageRepository.findAllPageSize();
    }
}
