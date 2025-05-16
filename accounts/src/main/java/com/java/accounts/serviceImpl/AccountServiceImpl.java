package com.java.accounts.serviceImpl;

import com.java.accounts.constants.AccountConstants;
import com.java.accounts.dto.AccountsDTO;
import com.java.accounts.dto.CustomerDTO;
import com.java.accounts.entity.Accounts;
import com.java.accounts.entity.Customer;
import com.java.accounts.exception.CustomerAlreadyExistsException;
import com.java.accounts.exception.ResourceNotFoundException;
import com.java.accounts.mapper.AccountsMapper;
import com.java.accounts.mapper.CustomerMapper;
import com.java.accounts.repo.AccountRepository;
import com.java.accounts.repo.CustomerRepository;
import com.java.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    /**
     * Create new account for customer.
     *
     * @param customerDTO
     */
    @Override
    public void createAccount(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.mapToCustomer(customerDTO, new Customer());
        Optional<Customer> byMobileNum = customerRepository.findByMobileNumber(customerDTO.getMobileNumber());
        if (byMobileNum.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer is already registered with given Mobile number " + customerDTO.getMobileNumber());
        }
        Customer savedCustomer = customerRepository.save(customer);
        accountRepository.save(createNewAccount(savedCustomer));

    }


    /**
     * Create new account for customer.
     *
     * @param customer
     * @return
     */
    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccountNumber = 100000000L + new Random().nextInt(900000000);
        newAccount.setAccountNumber(randomAccountNumber);
        newAccount.setAccountType(AccountConstants.SAVINGS);
        newAccount.setBranchAddress(AccountConstants.ADDRESS);
        return newAccount;
    }

    @Override
    public CustomerDTO fetchAccountDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Accounts accounts = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Accounts", "customerId", customer.getCustomerId().toString())
        );
        CustomerDTO customerDTO = CustomerMapper.mapToCustomerDto(customer, new CustomerDTO());
        customerDTO.setAccountDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDTO()));
        return customerDTO;
    }


    /**
     * Update account details for customer.
     *
     * @param customerDTO
     * @return
     */

    @Override
    public boolean updateAccountDetails(CustomerDTO customerDTO) {
        boolean isUpdated = false;
        AccountsDTO accountsDTO = customerDTO.getAccountDto();
        if (accountsDTO != null) {
            Accounts accounts = accountRepository.findById(accountsDTO.getAccountNumber()).orElseThrow(
                    () -> new ResourceNotFoundException("Accounts", "accountNumber", accountsDTO.getAccountNumber().toString()));
            AccountsMapper.mapToAccounts(accountsDTO, accounts);
            accounts = accountRepository.save(accounts);
            Long customerId = accounts.getCustomerId();
            Customer customer = customerRepository.findById(customerId).orElseThrow(
                    () -> new ResourceNotFoundException("Customer", "customerId", customerId.toString())
            );
            CustomerMapper.mapToCustomer(customerDTO, customer);
            customer = customerRepository.save(customer);
            isUpdated = true;
        }
        return isUpdated;
    }

    /**
     * Delete account for customer.
     *
     * @param mobileNumber
     * @return
     */

    @Override
    public boolean deleteAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        accountRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());
        return true;
    }
}
