package com.java.accounts.mapper;

import com.java.accounts.dto.AccountsDTO;
import com.java.accounts.entity.Accounts;

public class AccountsMapper {

//    public AccountsDTO mapToAccountsDTO(Accounts accounts, AccountsDTO accountsDTO) {
//        accountsDTO.setAccountNumber(accounts.getAccountNumber());
//        accountsDTO.setAccountType(accounts.getAccountType());
//        accountsDTO.setBranchAddress(accounts.getBranchAddress());
//        return accountsDTO;
//    }
//
//    public static Accounts mapToAccountsDto(AccountsDTO accountsDTO) {
//        Accounts accounts = new Accounts();
//        accounts.setAccountNumber(accountsDTO.getAccountNumber());
//        accounts.setAccountType(accountsDTO.getAccountType());
//        accounts.setBranchAddress(accountsDTO.getBranchAddress());
//        return accounts;
//    }

    public static AccountsDTO mapToAccountsDto(Accounts accounts, AccountsDTO accountsDto) {
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        return accountsDto;
    }

    public static Accounts mapToAccounts(AccountsDTO accountsDto, Accounts accounts) {
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accountsDto.getBranchAddress());
        return accounts;
    }


}


