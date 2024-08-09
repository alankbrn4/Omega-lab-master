package com.labclinico.omega.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI labInventoryOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Lab Inventory System API")
                        .version("1.0")
                        .description("API for managing lab inventory items"));
    }

}
