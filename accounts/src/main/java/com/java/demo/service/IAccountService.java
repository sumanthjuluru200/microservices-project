package com.java.demo.service;

import com.java.demo.dto.CustomerDTO;

import java.util.List;

public interface IAccountService {
    void createAccount(CustomerDTO customerDTO);
    CustomerDTO fetchAccountDetails(String mobileNumber);
}
