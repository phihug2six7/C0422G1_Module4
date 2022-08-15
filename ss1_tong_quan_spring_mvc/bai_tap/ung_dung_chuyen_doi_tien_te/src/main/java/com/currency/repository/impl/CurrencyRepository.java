package com.currency.repository.impl;

import com.currency.repository.ICurrencyRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CurrencyRepository implements ICurrencyRepository {
    @Override
    public float convert(float usd) {
        float result = usd * 23000;
        return result;
    }
}
