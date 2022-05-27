package com.vendas.apirest.config;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings("hiding")
@Configuration
@EnableSwagger2
public class SwaggerConfig<VendorExtension> {
	
	@Bean
    public Docket vendaApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.vendas.apirest"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }
	
	private ApiInfo metaInfo() {
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		ApiInfo apiInfo = new ApiInfo(
				"API Rest de vendas",
				"Utilizada nos processos de um PDV",
				"1.0",
				"Terms of Service",
				new Contact("André Luiz de Lima", "", "andre2051@hotmail.com"),
				"Apache License Version 2.0",
				"https://www.apache.org/license.html", (Collection<springfox.documentation.service.VendorExtension>) new ArrayList<VendorExtension>()
				);
		return apiInfo;
	}

}
