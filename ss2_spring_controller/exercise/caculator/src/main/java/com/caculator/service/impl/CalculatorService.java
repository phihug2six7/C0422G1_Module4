package com.caculator.service.impl;

import com.caculator.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public String choose(String number1, String number2, String action) {
        float numb1 = Float.parseFloat(number1);
        float numb2 = Float.parseFloat(number2);
        String result = "";
        switch (action) {
            case "Addition(+)":
                result = numb1 + numb2 + "";
                break;
            case "Subtraction(-)":
                result = numb1 - numb2 + "";
                break;
            case "Multiplication(X)":
                result = numb1 * numb2 + "";
                break;
            case "Division(/)":
                if (numb2 == 0) {
                    result = "2nd number cannot be 0";
                } else {
                    result = numb1 / numb2 + "";
                    break;
                }
        }
        return result;
    }
}
