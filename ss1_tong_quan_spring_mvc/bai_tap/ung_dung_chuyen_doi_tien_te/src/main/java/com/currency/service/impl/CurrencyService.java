package com.currency.service.impl;

import com.currency.repository.ICurrencyRepository;
import com.currency.service.ICurrencyService;
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
