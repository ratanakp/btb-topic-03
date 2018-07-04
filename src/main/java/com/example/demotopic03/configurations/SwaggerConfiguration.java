package com.example.demotopic03.configurations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {

        List<SecurityScheme> securitySchemes = new ArrayList<>();

        securitySchemes.add(new BasicAuth("basicAuth"));
        securitySchemes.add(new ApiKey("API KEY", "fsdfs", "sfdsfs"));


        return new Docket(DocumentationType.SWAGGER_2)
                .select()
//                .apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.example.demotopic03.controllers.restcontrollers")) // specific package
                .paths(PathSelectors.any())
//                .paths(PathSelectors.ant("/api/v1/book/**")) // specific path
                .build()
                .securitySchemes(securitySchemes)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        List<VendorExtension> vendorExtensions = new ArrayList<>();
//        vendorExtensions.add("")
        Contact contact = new Contact("Tem Chhannat", "",
                "temchannat@gmail.com");
        ApiInfo apiInformation = new ApiInfo(
                "BTB-6th-BMS",
                "Hanchey Resort Api Documentation",
                "Version 1.swagger-ui.swagger-ui",
                "Term of Service",
                contact,
                "License: Copy Righted",
                "http://www.hanchey.com",
                vendorExtensions
        );
        return apiInformation;
    }

}
