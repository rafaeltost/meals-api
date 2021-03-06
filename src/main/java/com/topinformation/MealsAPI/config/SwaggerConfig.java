package com.topinformation.MealsAPI.config;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.topinformation.MealsAPI"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "Meals API ",
                "API REST of Meals.", "1.0",
                "Terms of Service",
                new Contact("Rafael Tosta", "https://github.com/rafaeltost",
                        "rafaeltost@gmail.com"),
                "Apache License Version 2.0",
                "http://www.apache.org/licenses/", new ArrayList<VendorExtension>());

        return apiInfo;
    }


}