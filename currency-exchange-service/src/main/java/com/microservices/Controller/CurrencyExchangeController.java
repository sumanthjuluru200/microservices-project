package com.microservices.Controller;

import com.microservices.entity.CurrencyExchange;
import com.microservices.repository.CurrencyExchangeRepo;
import com.microservices.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchangeService currencyExchangeService;

    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retriveExchangeValue(@PathVariable String from, @PathVariable String to){

        CurrencyExchange exchange=new CurrencyExchange(1000L,from,to, BigDecimal.valueOf(50));
        String port= environment.getProperty("local.server.port");
       exchange.setEnvironment(port);
        return  exchange;
    }

    @PostMapping("/currency-exchange/save")
    public CurrencyExchange saveCurrencyExchange(@RequestBody CurrencyExchange currencyExchange){

        return currencyExchangeService.save(currencyExchange);
    }
}
