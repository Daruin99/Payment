package com.payment_service.payment_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Process-Payment  Endpoint")
                        .description("This API is used to process the payment using credit cards and check that the card has a sufficient balance, so, the payment can be done.")
                        .version("1.0.0"));
    }
}