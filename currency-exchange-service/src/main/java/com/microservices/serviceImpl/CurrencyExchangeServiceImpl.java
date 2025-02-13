package com.microservices.serviceImpl;

import com.microservices.entity.CurrencyExchange;
import com.microservices.repository.CurrencyExchangeRepo;
import com.microservices.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    @Autowired
    private CurrencyExchangeRepo currencyExchangeRepo;

    @Override
    public CurrencyExchange save(CurrencyExchange currencyExchange) {
        return currencyExchangeRepo.save(currencyExchange);
    }
}
