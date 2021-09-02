package com.besteco.converter.controller;

import com.besteco.converter.model.Money;
import com.besteco.converter.service.MoneyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MoneyController {

    private final MoneyService moneyService;

    public MoneyController(MoneyService moneyService) {
        this.moneyService = moneyService;
    }

    @GetMapping("/tlToUsd/{amount}")
    public Money convertTlToUsd(@RequestParam Integer amount){
        return moneyService.convertTlToUsd(amount);
    }

    @GetMapping("/usdToTl/{amount}")
    public Money convertUsdToTl(@RequestParam Integer amount){
        return moneyService.convertUsdToTl(amount);
    }
}
