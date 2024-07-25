package com.bank.Config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Bank ED807 API",
                description = "апи для ed807", version = "1.0.0",
                contact = @Contact(
                        name = "Четвергов Кирилл"
                )
        )
)
public class OpenApiConfig {

}
