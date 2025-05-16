package com.java.demo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDTO {

    @NotEmpty(message = "Account number is cannot be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Please provide a valid account number")
    private Long accountNumber;

    @NotEmpty(message = "Account type is cannot be null or empty")
    private String accountType;

    @NotEmpty(message = "Branch address is cannot be null or empty")
    private String branchAddress;
}
