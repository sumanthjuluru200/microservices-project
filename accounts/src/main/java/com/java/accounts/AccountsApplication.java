package com.java.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info = @Info(
                title = "Accounts Microservice REST API Documentation",
                description = "Eazybank Accounts Microservice REST API Documentation",
                version = "v1",
                contact = @Contact(
                        name = "Sumath Juluru",
                        email = "sjuluru9@gmail.com",
                        url = "https://github.com/sjuluru"),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://github.com/sjuluru"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Eazybank Accounts Microservice REST API Documentation",
                url = "https://github.com/sjuluru/eazybank-accounts-microservice"
        )
)
public class AccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }

}
