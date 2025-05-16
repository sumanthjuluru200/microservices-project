package com.java.accounts.service;

import com.java.accounts.dto.CustomerDTO;

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

    /**
     * Delete account for customer.
     * @param mobileNumber
     * @return
     */
    boolean deleteAccount(String mobileNumber);
}
