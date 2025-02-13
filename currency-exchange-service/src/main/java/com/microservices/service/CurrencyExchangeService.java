package com.microservices.service;

import com.microservices.CurrencyExchangeServiceApplication;
import com.microservices.entity.CurrencyExchange;

public interface CurrencyExchangeService {

    public CurrencyExchange save(CurrencyExchange currencyExchange);

}
