package com.java.demo.service;

import com.java.demo.dto.CustomerDTO;

import java.util.List;

public interface IAccountService {
    /**
     * Create new account for customer.
     * @param customerDTO
     */
    void createAccount(CustomerDTO customerDTO);

    /**
     * Fetch account details for customer.
     * @param mobileNumber
     * @return
     */
    CustomerDTO fetchAccountDetails(String mobileNumber);

    /**
     * Update account details for customer.
     * @param customerDTO
     * @return
     */
    boolean updateAccountDetails(CustomerDTO customerDTO);
}
