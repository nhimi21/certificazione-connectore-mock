package com.eng.api.certificazionidoc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.eng.api.certificazionidoc.controller"))
                .build()
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo());

    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Certificazioni Doc REST API",
                "API ",
                "1.0.0",
                null,
                new Contact(
                        "Engineering Ingegneria Informatica S.p.A.",
                        "http://www.eng.it",
                        "info@eng.it"),
                null,
                null,
                Collections.emptyList());
    }
}
