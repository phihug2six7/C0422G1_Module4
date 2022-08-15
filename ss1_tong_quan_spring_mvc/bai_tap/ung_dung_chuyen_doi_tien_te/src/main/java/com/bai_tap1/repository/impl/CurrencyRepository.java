package com.bai_tap1.repository.impl;

import com.bai_tap1.repository.ICurrencyRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CurrencyRepository implements ICurrencyRepository {
    @Override
    public float convert(float usd) {
        float result = usd * 23000;
        return result;
    }
}
