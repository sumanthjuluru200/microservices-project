package com.java.accounts.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.Check;

@Data
@Schema(
        name = "Customer",
        description = "Schema can hold Customer Information"
)
public class CustomerDTO {

    @Schema(
            description = "Name of the customer", example = "Eazy Bites"
    )
    @NotEmpty(message = "Name is cannot be null or empty")
    @Size(min = 3, max = 30, message = "Name should be between 3 and 30 characters")
    private String name;

    @Schema(
            description = "Email of the customer", example = "sjuluru@gmail.com"
    )
    @NotEmpty(message = "Email is cannot be null or empty")
    @Email(message = "Please provide a valid email address")
    private String email;

    @Schema(
            description = "Mobile number of the customer", example = "9999999999"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Please provide a valid mobile number")
    private String mobileNumber;
    @JsonProperty("accountDetails")
    @Schema(
            description = "Account details of Customer"
    )
    private AccountsDTO accountDto;
}
