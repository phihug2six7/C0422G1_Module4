package com.example.service;

import com.example.model.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPhoneService {
    Page<Phone> findAll(Pageable pageable);

    void save(Phone phone);

    void delete(Integer id);

    Phone findById(Integer id);
}
