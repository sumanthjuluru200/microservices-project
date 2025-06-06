package com.java.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(
        name = "Response",
        description = "Schema to hold the Response Information"
)
public class ResponseDto {

    @Schema(
            description = "Status code in the Response"
    )
    private String statusCode;

    @Schema(
            description = "Status message in the Response"
    )
    private String statusMsg;
}
