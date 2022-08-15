package com.bai_tap1.service.impl;

import com.bai_tap1.repository.ICurrencyRepository;
import com.bai_tap1.service.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService implements ICurrencyService {
    @Autowired
    ICurrencyRepository iCurrencyRepository;

    @Override
    public float convert(float usd) {
        return iCurrencyRepository.convert(usd);
    }
}
