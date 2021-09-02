package com.besteco.converter.service;

import com.besteco.converter.model.Money;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MoneyService {

    @Value("${tlUsd.exchangerate}")
    private Double convertRate;

    public Money convertTlToUsd(Integer amount) {
        return new Money((amount*(100/convertRate)),"USD");
    }

    public Money convertUsdToTl(Integer amount){
        return new Money((amount*(convertRate)),"TL");
    }
}
