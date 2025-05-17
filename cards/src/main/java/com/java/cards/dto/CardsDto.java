package com.java.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;


@Data
@Schema(
        description = "Schema to hold the Card Information"
)
public class CardsDto {
    @NotEmpty(message = "Mobile number is cannot be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Please provide a valid mobile number")
    @Schema(
            description = "Mobile number of the customer", example = "1234567890"
    )
    private String mobileNumber;

    @NotEmpty(message = "Card number is cannot be null or empty")
    @Pattern(regexp = "(^$|[0-9]{12})", message = "Curd number must be 12 digits")
    @Schema(
            description = "Card number of the customer", example = "123456789845"
    )
    private String cardNumber;

    @NotEmpty(message = "Card type is cannot be null or empty")
    @Schema(
            description = "Card type of the customer", example = "Credit Card"
    )
    private String cardType;

    @Positive(message = "Total card limit should be greater than zero")
    @Schema(
            description = "Total card limit of the customer", example = "10000"
    )
    private int totalLimit;

    @PositiveOrZero(message = "Amount used should be greater than or equal to zero")
    @Schema(
            description = "Amount used of the customer", example = "1000"
    )
    private int amountUsed;

    @PositiveOrZero(message = "Available amount should be greater than or equal to zero")
    @Schema(
            description = "Total amount available against a card", example = "9000"
    )
    private int availableAmount;
}
