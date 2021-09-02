package com.besteco.secondhomework.controller;

import com.besteco.secondhomework.models.Money;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class MoneyController {

    private final RestTemplate restTemplate;

    public MoneyController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/convert100TltoUsd")
    public Money convert100TltoUsd(){
        Money money = restTemplate.getForObject("http://localhost:8081/api/convertTlToUsd/100", Money.class);
        return money;
    }

    @GetMapping("/convert100UsdtoTl")
    public Money convert100UsdtoTl(){
        Money money = restTemplate.getForObject("http://localhost:8081/api/convertUsdtoTl/100", Money.class);
        return money;
    }
}
