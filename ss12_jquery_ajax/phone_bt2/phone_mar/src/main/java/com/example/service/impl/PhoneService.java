package com.example.service.impl;

import com.example.model.Phone;
import com.example.repository.IPhoneRepository;
import com.example.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PhoneService implements IPhoneService {

    @Autowired
    private IPhoneRepository iPhoneRepository;
    @Override
    public Page<Phone> findAll(Pageable pageable) {
        return iPhoneRepository.findAll(pageable);
    }

    @Override
    public void save(Phone phone) {
        iPhoneRepository.save(phone);
    }

    @Override
    public void delete(Integer id) {
        iPhoneRepository.deleteById(id);
    }

    @Override
    public Phone findById(Integer id) {
        return iPhoneRepository.findById(id).orElse(new Phone());
    }
}
