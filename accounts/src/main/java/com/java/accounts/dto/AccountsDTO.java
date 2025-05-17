package com.java.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold the Account Information"
)
public class AccountsDTO {

    @NotEmpty(message = "Account number is cannot be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Please provide a valid account number")
    @Schema(
            description = "Account number of Eazy Bank Account", example = "1234567890"
    )
    private Long accountNumber;

    @Schema(
            description = "Account type of Eazy Bank Account", example = "SAVINGS"
    )
    @NotEmpty(message = "Account type is cannot be null or empty")
    private String accountType;

    @Schema(
            description = "Eazy Bank branch Address", example = "Kondapur"
    )
    @NotEmpty(message = "Branch address is cannot be null or empty")
    private String branchAddress;
}
