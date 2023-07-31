package com.jumarket.api.configs

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Bean
    fun customApiConfig(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                .title("Documentação da API sobre o Sistema JuMarket")
                .version("Version 1 (v1)")
                .description("Esta documentação apresenta os endpoints " +
                        "responsáveis pelas funcionalidades de Categorias, " +
                        "Produtos e carrinhos de compra.")
                .termsOfService("http://mytersm.com")
                .license(
                    License()
                    .name("Apache 2.0")
                    .url("http://mylicences.com"))
            );
    }

}