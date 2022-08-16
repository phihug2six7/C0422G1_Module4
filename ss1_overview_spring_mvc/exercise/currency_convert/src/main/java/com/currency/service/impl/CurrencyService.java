package com.currency.service.impl;

import com.currency.service.ICurrencyService;

import org.springframework.stereotype.Service;

@Service
public class CurrencyService implements ICurrencyService {

    @Override
    public float convert(float usd) {
            float result = usd * 23000;
            return result;
    }
}
