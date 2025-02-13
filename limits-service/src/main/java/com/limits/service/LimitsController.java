package com.limits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    private LimitsConfiguration configuration;

    @GetMapping("/limits")
    public Limits getLimist(){
//        return new Limits(1,1000);
        return new Limits(configuration.getMinimum(), configuration.getMaximum());
    }
}
